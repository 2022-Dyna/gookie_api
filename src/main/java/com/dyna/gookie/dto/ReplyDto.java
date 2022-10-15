package com.dyna.gookie.dto;

import com.dyna.gookie.entity.Pagination;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("ReplyDto")
public class ReplyDto {
    private List<ReplyListDto> replyList;
    private Pagination pagination;
}
