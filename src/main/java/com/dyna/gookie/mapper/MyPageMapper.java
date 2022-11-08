package com.dyna.gookie.mapper;

import com.dyna.gookie.dto.CongressReplyDto;
import com.dyna.gookie.dto.FavoritesInfoDto;
import com.dyna.gookie.dto.PasswordDto;
import com.dyna.gookie.dto.ReplyListDto;
import com.dyna.gookie.entity.Favorites;
import com.dyna.gookie.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {
    Member myPage(@Param("memberId") long memberId);

    int myReplyCount(@Param("memberId") long memberId);

    List<ReplyListDto> myReplyList(@Param("memberId") long memberId, @Param("offset") int offset, @Param("limit") int limit);

    int myCongressReplyCount(@Param("memberId") long memberId);

    List<CongressReplyDto> myCongressReplyList(@Param("memberId") long memberId, @Param("offset") int offset, @Param("limit") int limit);

    String selectPw(long memberId);

    void passWordUpdate(@Param("member") PasswordDto dto);

    List<FavoritesInfoDto> myFavorites(@Param("memberId") long memberId);

    int insFavorites(String memberId, String monaCd);
}
