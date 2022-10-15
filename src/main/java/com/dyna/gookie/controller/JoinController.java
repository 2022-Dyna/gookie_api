package com.dyna.gookie.controller;

import com.dyna.gookie.dto.MemberJoinDto;
import com.dyna.gookie.service.JoinService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/join")
public class JoinController {

    private final JoinService joinService;

    //TODO 아이디 중복체크
    @GetMapping
    public ResponseEntity idCheck(@RequestParam(value = "memberLoginId") String memberLoginId){
        HttpHeaders httpHeaders = new HttpHeaders();

        HashMap<String, Object> map = joinService.idCheck(memberLoginId);

        Response response = new Response(200, "연결 성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);

    }

    //TODO 회원가입
    @PostMapping
    public ResponseEntity join(@RequestBody MemberJoinDto member) throws MessagingException {
        HttpHeaders httpHeaders = new HttpHeaders();

        int result = joinService.join(member);

        Response response = new Response(200, "연결 성공", result);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
