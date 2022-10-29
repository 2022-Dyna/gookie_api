package com.dyna.gookie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("ReplyListDto")
public class ReplyListDto {

    //TODO 댓글 고유번호
    private long replyId;
    //TODO 멤버 고유번호
    private long memberId;
    //TODO 국횓의원 고유번호
    private long congressId;
    //TODO 댓글 내용
    private String replyContent;
    //TODO 댓글 생성일
    private String replyCreateDate;
    //TODO 댓글 수정일
    private String replyModifyDate;
    //TODO 댓글 상태 0삭제 1 활성
    private int replyStatus;
    //TODO 댓글 작성자 이름
    private String memberName;

    //TODO 댓글에 달린 좋아요 슨
    private long likesCount;
}
