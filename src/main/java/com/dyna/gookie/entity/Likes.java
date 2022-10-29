package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Likes")
public class Likes {
    private long likesId;
    private long replyId;
    private long memberId;
    private int likesType;
}
