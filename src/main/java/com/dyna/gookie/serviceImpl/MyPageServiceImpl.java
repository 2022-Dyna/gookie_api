package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Member;
import com.dyna.gookie.mapper.MyPageMapper;
import com.dyna.gookie.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private final MyPageMapper myPageMapper;

    @Override
    public HashMap<String, Object> myPage(long memberId){
        HashMap<String, Object> map = new HashMap<>();
        Member member = myPageMapper.myPage(memberId);
        map.put("data", member);
        return map;
    }

}
