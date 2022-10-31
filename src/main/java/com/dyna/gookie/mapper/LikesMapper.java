package com.dyna.gookie.mapper;

import com.dyna.gookie.entity.Likes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikesMapper {
    int likes(Likes likes);

    int likesPutItIn(@Param("count") int count,@Param("likes") Likes likes);
}
