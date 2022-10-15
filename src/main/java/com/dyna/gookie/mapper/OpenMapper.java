package com.dyna.gookie.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface OpenMapper {
    void insertGookie(HashMap<String, Object> resultMap);
}
