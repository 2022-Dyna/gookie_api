package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Gookie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GookieMapper {
    //TODO 국회의원 상세 정보
    Gookie detailGookie(String monaCd);
}
