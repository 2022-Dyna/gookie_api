package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyPageMapper {
    Member myPage(@Param("memberId") long memberId);
}
