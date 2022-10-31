package com.dyna.gookie.controller;

import com.dyna.gookie.entity.Likes;
import com.dyna.gookie.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikesController {
    private final LikeService likeService;

    @PostMapping
    public HashMap<String, Object> likes(@RequestBody Likes likes){
        return likeService.likes(likes);
    }
}
