package com.dyna.gookie.service;


import com.dyna.gookie.dto.ReplyDto;
import com.dyna.gookie.entity.Reply;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;

public interface ReplyService {

    //TODO 해당 국회의원에 대한 댓글 리스트
    ReplyDto replyList(String monaCd, int pageNum, int sort);

    //TODO 댓글작성
    String replyWrite(HttpServletRequest request, Reply reply);

    //TODO 댓글수정
    String replyModify(HttpServletRequest request, Reply reply);

    //TODO 댓글삭제
    String replyDelete(HttpServletRequest request, Reply reply);

    //TODO 베스트 댓글 작성
    HashMap<String, Object> bestReplyList(int sort) throws ParseException;
}
