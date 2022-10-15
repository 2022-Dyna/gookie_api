package com.dyna.gookie.service;

import java.util.HashMap;

public interface GookieService {

    //TODO 국회의원 상세 정보
    HashMap<String, Object> detailGookie(String eMail, String monaCd);
}
