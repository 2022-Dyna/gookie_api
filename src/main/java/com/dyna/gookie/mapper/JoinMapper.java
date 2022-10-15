package com.dyna.gookie.mapper;

import com.dyna.gookie.dto.MemberJoinDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {

    //TODO 아이디 중복체크
    int idCheck(String memberLoginId);

    //TODO 회원 가입
    int join(MemberJoinDto dto);

}
