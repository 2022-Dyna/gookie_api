package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Gookie;
import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.service.GookieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class GookieServiceImpl implements GookieService {

    private final GookieMapper gookieMapper;

    //TODO 국회의원 상세 정보
    @Override
    public HashMap<String, Object> detailGookie(String eMail, String monaCd){
        HashMap<String, Object> map = new HashMap<>();
        Gookie gookie = gookieMapper.detailGookie(eMail, monaCd);
        if (gookie == null){
            map.put("result", "데이터를 불러올 수 업습니다.");
        }else {
            map.put("result", gookie);
        }
        return map;
    }
}
