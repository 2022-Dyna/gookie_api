package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Member;
import com.dyna.gookie.mapper.LoginMapper;
import com.dyna.gookie.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;
    //TODO 로그인
    @Override
    public int login(HashMap<String ,Object> requestMap){
        Member member = loginMapper.login((String)requestMap.get("memberLoginId"));
        if (ObjectUtils.isEmpty(member)){
            return 1;
        }
        if(BCrypt.checkpw((String)requestMap.get("memberLoginPw"), member.getMemberLoginPw())){
            return 0;
        }else {
         return 2;
        }
    }
}
