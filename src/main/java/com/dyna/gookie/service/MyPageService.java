package com.dyna.gookie.service;

import com.dyna.gookie.dto.PasswordDto;

import java.util.HashMap;

public interface MyPageService {
    HashMap<String, Object> myPage(long memberId);

    HashMap<String, Object> myReply(long memberId, String memberRole, int pageNum, int limit);

    HashMap<String, Object> myPageUpdate(PasswordDto dto);

    HashMap<String, Object> myFavorites(long memberId);

    HashMap<String, Object> insFavorites(long memberId, String monaCd);
}
