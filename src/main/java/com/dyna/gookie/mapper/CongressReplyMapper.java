package com.dyna.gookie.mapper;

import com.dyna.gookie.dto.CongressReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CongressReplyMapper {
    List<CongressReplyDto> congressReplyList(@Param("replyId") int replyId);

    int insCongressReply(@Param("memberId") int memberId, @Param("replyId") int replyId, @Param("congressReplyContent") String congressReplyContent);

    int updCongressReply(@Param("congressReplyId") int congressReplyId, @Param("congressReplyContent") String congressReplyContent);

    int delCongressReply(@Param("congressReplyId") int congressReplyId);

}
