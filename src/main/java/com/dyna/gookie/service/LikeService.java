package com.dyna.gookie.service;

import com.dyna.gookie.entity.Likes;

import java.util.HashMap;

public interface LikeService {
    HashMap<String, Object> likes(Likes likes);
}
