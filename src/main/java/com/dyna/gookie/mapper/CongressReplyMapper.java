package com.dyna.gookie.mapper;

import com.dyna.gookie.dto.CongressReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CongressReplyMapper {
    List<CongressReplyDto> congressReplyList(@Param("replyId") long replyId);

    int insCongressReply(@Param("memberId") long memberId, @Param("replyId") long replyId, @Param("congressReplyContent") String congressReplyContent);

    int updCongressReply(@Param("congressReplyId") long congressReplyId,  @Param("memberId") long memberId, @Param("congressReplyContent") String congressReplyContent);

    int delCongressReply(@Param("congressReplyId") long congressReplyId, @Param("memberId") long memberId);

}
