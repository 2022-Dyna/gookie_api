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
@Alias("CongressReplyListDto")
public class CongressReplyListDto {
    private List<CongressReplyDto> congressReplyList;
    private Pagination pagination;
}
