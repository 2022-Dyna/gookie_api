package com.dyna.gookie.service;

import com.dyna.gookie.dto.MemberJoinDto;

import java.util.HashMap;

public interface JoinService {
    //TODO 아이디 중복체크
    HashMap<String, Object> idCheck(String memberLoginId);

    //TODO 회원가입
    int join(MemberJoinDto member);

}
