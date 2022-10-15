package com.dyna.gookie.controller;

import com.dyna.gookie.service.MailService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity send(@RequestParam(value = "memLoginId") String memLoginId) throws MessagingException
    {
        HttpHeaders httpHeaders = new HttpHeaders();

        String mail = mailService.send(memLoginId);

        Response response = new Response(200, "성공", mail);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
