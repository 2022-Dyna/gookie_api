package com.dyna.gookie.dto;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("FavoritesInfoDto")
public class FavoritesInfoDto {
    private String hgNm;
    private String polyNm;
}
