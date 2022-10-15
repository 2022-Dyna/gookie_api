package com.dyna.gookie.serviceImpl;


import com.dyna.gookie.mapper.OpenMapper;
import com.dyna.gookie.service.OpenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class OpenServiceImpl implements OpenService {

    private final OpenMapper openMapper;

    @Override
    @Transactional
    public void insertGookie(HashMap<String, Object> resultMap) {
        openMapper.insertGookie(resultMap);
    }
}
