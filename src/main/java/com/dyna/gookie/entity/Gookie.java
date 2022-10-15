package com.dyna.gookie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Gookie")
public class Gookie {

    private int gookieId;
    private String telNo;
    private String bthGbnNm;
    private String assemAddr;
    private String hjNm;
    private String hgNm;
    private String bthDate;
    private String electGbnNm;
    private String polyNm;
    private String reeleGbnNm;
    private String cmits;
    private String memTitle;
    private String engNm;
    private String sexGbnNm;
    private String eMail;
    private String monaCd;
    private String selectary2;
    private String jobResNm;
    private String staff;
    private String homepage;
    private String cmitNm;
    private String selectary;
    private String origNm;
    private String unuts;

}
