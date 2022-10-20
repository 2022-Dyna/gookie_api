package com.dyna.gookie.controller;

import com.dyna.gookie.entity.Gookie;
import com.dyna.gookie.service.GookieService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gookie")
public class GookieController {

    private final GookieService gookieService;

    //TODO 국희의원 상세정보
   @GetMapping
    public ResponseEntity detailGookie(@RequestParam(value = "monaCd") String monaCd){

        HttpHeaders httpHeaders = new HttpHeaders();

        Gookie gookie = gookieService.detailGookie(monaCd);

        Response response = new Response(200, "성공", gookie);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }
}
