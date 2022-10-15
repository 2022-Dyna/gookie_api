package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.dto.MemberJoinDto;
import com.dyna.gookie.mapper.JoinMapper;
import com.dyna.gookie.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {

    private final JoinMapper joinMapper;

    //TODO 아이디 중복체크
    @Override
    public HashMap<String, Object> idCheck(String memberLoginId){

        HashMap<String, Object> map = new HashMap<String, Object>();

        int id = joinMapper.idCheck(memberLoginId);

        map.put("check", id);

        if (id == 0){
            map.put("msg", "사용 가능한 아이디입니다.");
        }else{
            map.put("msg", "사용 불가능한 아이디입니다.");
        }

        return map;
    }

    //TODO 회원가입
    @Override
    public int join(MemberJoinDto member){
        String pw = BCrypt.hashpw(member.getMemberLoginPw(), BCrypt.gensalt());
        member.setMemberLoginPw(pw);
        if (!member.getMonaCd().isEmpty()){

        }
        return joinMapper.join(member);
    }
}
