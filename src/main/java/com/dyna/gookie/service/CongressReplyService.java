package com.dyna.gookie.service;

import com.dyna.gookie.dto.CongressReplyDto;

import java.util.HashMap;

public interface CongressReplyService {
    HashMap<String, Object> congressReplyList(int replyId);

    HashMap<String, Object> insCongressReply(CongressReplyDto dto);

    HashMap<String, Object> updCongressReply(CongressReplyDto dto);

    HashMap<String, Object> delCongressReply(CongressReplyDto dto);
}
