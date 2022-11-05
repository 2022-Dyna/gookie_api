package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Reply")
public class Reply {

    //TODO 댓글 고유번호
    private long replyId;
    //TODO 멤버 고유번호
    private long memberId;
    //TODO 국횓의원 고유번호
    private String monaCd;
    //TODO 댓글 내용
    private String replyContent;
    //TODO 댓글 상태 0삭제 1 활성
    private int replyStatus;
    //TODO 댓글 생성일
    private String replyCreateDate;
    //TODO 댓글 수정일
    private String replyModifyDate;

    private String role;
}
