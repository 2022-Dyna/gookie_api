package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Member")
public class Member {

    //TODO 멤버고유번호
    private Long memberId;
    //TODO 멤버 로그인 아이디(이메일 형식)
    private String memberLoginId;
    //TODO 멤버 로그인 비밀번호
    private String memberLoginPw;
    //TODO 멤버 이름
    private String memberName;
    //TODO 멤버 권한(국회의원, 일반유저)
    private String memberRole;
    //TODO 멤버 생성일
    private String memberCreateDate;
    //TODO 멤버 수정일
    private String memberModifyDate;

}
