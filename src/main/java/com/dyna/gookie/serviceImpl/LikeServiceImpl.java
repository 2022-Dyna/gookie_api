package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Likes;
import com.dyna.gookie.mapper.LikesMapper;
import com.dyna.gookie.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikesMapper likesMapper;

    @Override
    public HashMap<String, Object> likes(Likes likes){
        HashMap<String, Object> map = new HashMap<>();
        int count = likesMapper.likes(likes);
        int number = likesMapper.likesPutItIn(count, likes);
        if (number == 0){
            map.put("fail", "실패");
        }else {
            map.put("success", "성공");
        }
        return map;
    }

}
