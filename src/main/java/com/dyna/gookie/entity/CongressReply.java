package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CongressReply")
public class CongressReply {
    private long congressReplyId;
    private long replyId;
    private long memberId;
    private String congressReplyContent;
    private int congressReplyIndex;
    private int congressReplyStatus;
    private String congressReplyCreateDate;
    private String congressReplyModifyDate;
}
