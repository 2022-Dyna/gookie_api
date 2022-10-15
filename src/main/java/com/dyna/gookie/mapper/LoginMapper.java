package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //TODO 로그인
    Member login(String memberLoginId);
}
