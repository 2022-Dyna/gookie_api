package com.dyna.gookie.service;

import java.util.HashMap;
import java.util.List;

public interface GookieService {

    //TODO 국회의원 상세 정보
    HashMap<String, Object> detailGookie(String eMail, String monaCd);

    //TODO 국회의원 상세 정보
    List<HashMap<String, Object>> getMeetingList();

    List<HashMap<String, Object>> getGookieList();
}
