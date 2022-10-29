package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Gookie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GookieMapper {
    //TODO 국회의원 상세 정보
    Gookie detailGookie(@Param("eMail") String eMail, @Param("monaCd") String monaCd);

    //TODO 국회의원 상세 정보
    List<HashMap<String,Object>> getMeetingList();

    //TODO 국회의원 전체
    List<HashMap<String,Object>> getGookieList();
}
