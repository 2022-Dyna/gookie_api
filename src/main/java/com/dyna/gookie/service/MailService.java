package com.dyna.gookie.service;


import javax.mail.MessagingException;

public interface MailService {
    //TODO 메일 인증번호 전송
    String send(String memLoginId) throws MessagingException;
}
