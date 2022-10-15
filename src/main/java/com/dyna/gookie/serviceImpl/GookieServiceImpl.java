package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Gookie;
import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.service.GookieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GookieServiceImpl implements GookieService {

    private final GookieMapper gookieMapper;

    //TODO 국회의원 상세 정보
    @Override
    public Gookie detailGookie(String monaCd){
        return gookieMapper.detailGookie(monaCd);
    }
}
