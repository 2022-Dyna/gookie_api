package com.dyna.gookie.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    //TODO 로그인
    String login(String memberLoginId, String memberLoginPw, HttpServletRequest request);
}
