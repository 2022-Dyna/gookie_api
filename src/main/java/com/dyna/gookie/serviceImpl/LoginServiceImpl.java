package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Member;
import com.dyna.gookie.mapper.LoginMapper;
import com.dyna.gookie.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;
    //TODO 로그인
    @Override
    public String login(String memberLoginId, String memberLoginPw){
        Member member = loginMapper.login(memberLoginId);
        if (ObjectUtils.isEmpty(member)){
            return "가입되지 않은 회원입니다";
        }
        if(BCrypt.checkpw(memberLoginPw, member.getMemberLoginPw())){
            return "로그인 성공";
        }else {
         return "로그인 실패";
        }
    }
}
