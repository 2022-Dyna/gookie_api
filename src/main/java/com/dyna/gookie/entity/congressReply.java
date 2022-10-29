package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("congressReply")
public class congressReply {
    private long congressReplyId;
    private long replyId;
    private long memberId;
    private String congress_reply_content;
    private int congress_reply_index;
    private String congress_reply_create_date;
    private String congress_reply_modify_date;
}
