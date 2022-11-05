package com.dyna.gookie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("CongressReplyDto")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CongressReplyDto {
    private long congressReplyId;
    private long memberId;
    private long replyId;
    private String memberName;
    private String congressReplyContent;
    private String congressReplyCreateDate;
    private String congressReplyModifyDate;
    private String likesCount;

}
