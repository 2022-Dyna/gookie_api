package com.dyna.gookie.controller;

import com.dyna.gookie.dto.PasswordDto;
import com.dyna.gookie.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/select")
    public HashMap<String, Object> myPage(@RequestParam(value = "memberId") long memberId){
        return myPageService.myPage(memberId);
    }

    @GetMapping("/favorites")
    public HashMap<String, Object> myFavorites(@RequestParam(value = "memberId") long memberId){
        return myPageService.myFavorites(memberId);
    }

    @GetMapping("/reply")
    public HashMap<String, Object> myReply(@RequestParam(value = "memberId") long memberId, @RequestParam(value = "memberRole") String memberRole,
                                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "5") int limit){
        return myPageService.myReply(memberId, memberRole, pageNum, limit);
    }

    @PostMapping("/update")
    public HashMap<String, Object> myPageUpdate(@RequestBody PasswordDto dto){
        return myPageService.myPageUpdate(dto);
    }

    @PostMapping("/favorites")
    public HashMap<String, Object> insFavorites(@RequestParam(value = "memberId") long memberId, @RequestParam(value = "monaCd") String monaCd){
        return myPageService.insFavorites(memberId, monaCd);
    }

}
