package com.dyna.gookie.service;

import java.util.HashMap;
import java.util.List;

public interface GookieService {

    //TODO 국회의원 상세 정보
    HashMap<String, Object> detailGookie(String monaCd,String member_id);

    //TODO 국회의원 상세 정보
    List<HashMap<String, Object>> getMeetingList();

    List<HashMap<String, Object>> getGookieList(String state);

    HashMap<String, Object> getGookieListState(String state);

    List<HashMap<String, Object>> getBestCom();

    List<HashMap<String, Object>> getMostFa();
}
