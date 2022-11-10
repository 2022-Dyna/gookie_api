package com.dyna.gookie.controller;

import com.dyna.gookie.dto.PasswordDto;
import com.dyna.gookie.entity.Member;
import com.dyna.gookie.mapper.LoginMapper;
import com.dyna.gookie.mapper.MyPageMapper;
import com.dyna.gookie.service.MailService;
import com.dyna.gookie.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mypage")
public class MyPageController {
    private final MyPageService myPageService;
    @Autowired
    private final MailService mailService;
    @Autowired
    private final LoginMapper loginMapper;
    @Autowired
    private final MyPageMapper myPageMapper;


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
        System.out.println(dto.toString());
        return myPageService.myPageUpdate(dto);
    }

    @PostMapping("/changePw")
    public HashMap<String, Object> changePw(@RequestBody HashMap<String,Object> paramMap){
        Member loginUser = loginMapper.login((String)paramMap.get("email"));
        HashMap<String,Object> result = new HashMap<>();
        if(loginUser==null){
            result.put("error","2");
            return result;
        }
        try {
            String pw = mailService.createPw(loginUser.getMemberLoginId(),loginUser.getMemberName());
            PasswordDto dto = new PasswordDto();
            String changePw = BCrypt.hashpw(pw, BCrypt.gensalt());
            dto.setChangePw(changePw);
            dto.setMemberId(loginUser.getMemberId());
            myPageMapper.passWordUpdate(dto);
            result.put("error","0");
        }catch (Exception e){

        }
        return result;
    }

    @GetMapping("/insfavorites")
    public HashMap<String, Object> insFavorites(@RequestParam(value = "memberId") String memberId, @RequestParam(value = "monaCd") String monaCd){
        return myPageService.insFavorites(memberId, monaCd);
    }

}
