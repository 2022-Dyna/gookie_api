package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Favorites")
public class Favorites {

    private int favoritesId;
    private int memId;
    private String monaCd;
}
