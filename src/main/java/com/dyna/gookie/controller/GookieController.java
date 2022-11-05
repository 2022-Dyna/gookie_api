package com.dyna.gookie.controller;

import com.dyna.gookie.service.GookieService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gookie")
public class GookieController {

    private final GookieService gookieService;

    //TODO 국희의원 상세정보
   @GetMapping("/detail")
    public ResponseEntity detailGookie(@RequestParam(value = "eMail") String eMail, @RequestParam(value = "monaCd") String monaCd){

        HttpHeaders httpHeaders = new HttpHeaders();

        HashMap<String, Object> map = gookieService.detailGookie(eMail, monaCd);

        map.put("meetingAtt","98");
        map.put("replyPer","54");

        System.out.println(map.toString());
        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity listGookie(@RequestParam(value = "state") String state){

        HttpHeaders httpHeaders = new HttpHeaders();

        HashMap<String, Object> map = gookieService.getGookieListState(state);

        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/image")
    public ResponseEntity getConImage(){

        HttpHeaders httpHeaders = new HttpHeaders();

        Response response = new Response(200, "성공", "map");

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }
}
