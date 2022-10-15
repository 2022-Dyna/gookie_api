package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Member;
import com.dyna.gookie.mapper.LoginMapper;
import com.dyna.gookie.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;
    //TODO 로그인
    @Override
    public String login(String memberLoginId, String memberLoginPw, HttpServletRequest request){
        Member member = loginMapper.login(memberLoginId);
        HttpSession session = request.getSession();

        if(BCrypt.checkpw(memberLoginPw, member.getMemberLoginPw())){
            session.setAttribute("login", true);
            session.setMaxInactiveInterval(3600 * 24);
            return "로그인 성공";
        }else {
            session.setAttribute("login", false);
         return "로그인 실패";
        }
    }
}
