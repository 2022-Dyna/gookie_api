package com.dyna.gookie.controller;

import com.dyna.gookie.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping
    public HashMap<String, Object> myPage(@RequestParam(value = "memberId") long memberId){
        return myPageService.myPage(memberId);
    }


}
