package com.dyna.gookie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("PasswordDto")
public class PasswordDto {
    private long memberId;
    private String memberLoginPw;
    private String changePw;
}
