package com.dyna.gookie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("MemberJoinDto")
public class MemberJoinDto {
    //TODO 멤버 로그인 아이디(이메일 형식)
    private String memberLoginId;
    //TODO 멤버 로그인 비밀번호
    private String memberLoginPw;
    //TODO 멤버 이름
    private String memberName;
    //TODO 멤버 권한(국회의원, 일반유저)
    private String monaCd;

    //TODO 국회 회원가입 여부
    private int role;
}
