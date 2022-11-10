package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Gookie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GookieMapper {
    //TODO 국회의원 상세 정보
    Gookie detailGookie( @Param("monaCd") String monaCd,@Param("member_id") String member_id);

    //TODO 국회의원 상세 정보
    List<HashMap<String,Object>> getMeetingList();

    //TODO 국회의원 전체
    List<HashMap<String,Object>> getGookieList();

    List<HashMap<String,Object>> getBestCom();

    List<HashMap<String,Object>> getMostFa();

    List<HashMap<String,Object>> getMillId();
    List<HashMap<String,Object>> getAlarm(HashMap<String,Object> hashMap);

    List<HashMap<String,Object>> meetingResult(HashMap<String,Object> hashMap);
    List<HashMap<String,Object>> getPresent(HashMap<String,Object> hashMap);

    int insertOpenApi(HashMap<String,Object> hashMap);
    int insAlarm(HashMap<String,Object> hashMap);

    HashMap<String,Object> getMyRate(HashMap<String,Object> paramMap);
}
