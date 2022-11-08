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
    public HashMap<String,Object> login(HashMap<String ,Object> requestMap){
        HashMap<String ,Object> resultMap = new HashMap<>();
        Member member = loginMapper.login((String)requestMap.get("memberLoginId"));
        System.out.println(member);
        if (ObjectUtils.isEmpty(member)){
            resultMap.put("result","1");
            return resultMap;
        }
        if(BCrypt.checkpw((String)requestMap.get("memberLoginPw"), member.getMemberLoginPw())){
            resultMap.put("result","0");
            resultMap.put("loginObj",member);
            return resultMap;
        }else {
            resultMap.put("result","2");
         return resultMap;
        }
    }
}
