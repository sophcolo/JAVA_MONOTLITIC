package com.api.web.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @JsonProperty("usr130") private String usr;
    @JsonProperty("ten130") private String ten;
    @JsonProperty("ent130") private String ent;
    @JsonProperty("nam130") private String nam;
    @JsonProperty("pss130") private String pss;
    @JsonProperty("try130") private BigDecimal ctry;
    @JsonProperty("pid130") private String pid;
    @JsonProperty("chp130") private String chp;
    @JsonProperty("idi130") private String idi;
    @JsonProperty("idt130") private String idt;
    @JsonProperty("ctr130") private String ctr;
    @JsonProperty("add130") private String f_add;
    @JsonProperty("pem130") private String pem;
    @JsonProperty("com130") private String com;
    @JsonProperty("chg130") private String chg;
    @JsonProperty("dch130") private Date dch;
    @JsonProperty("ada130") private Date ada;
    @JsonProperty("pob130") private String pob;
    @JsonProperty("tea130") private String tea;
    @JsonProperty("tel130") private String tel;
    @JsonProperty("faa130") private String faa;
    @JsonProperty("fax130") private String fax;
    @JsonProperty("key130") private String ckey;
    @JsonProperty("ran130") private String ran;
    @JsonProperty("chy130") private BigDecimal chy;
    @JsonProperty("inc130") private String inc;
    @JsonProperty("sts130") private String sts;
    @JsonProperty("aus130") private String aus;
    @JsonProperty("lty130") private String lty;
    @JsonProperty("crd130") private Date crd;
    @JsonProperty("off130") private String off;
    @JsonProperty("ecc130") private String ecc;
    @JsonProperty("ans130") private String ans;
    @JsonProperty("que130") private String que;
    @JsonProperty("ulg130") private String ulg;
    @JsonProperty("lli130") private Date lli;
    @JsonProperty("app130") private String app;
    @JsonProperty("mig130") private String mig;
    @JsonProperty("fir130") private Date fir;
    @JsonProperty("mus130") private String mus;
    @JsonProperty("mdt130") private Date mdt;
    @JsonProperty("aty130") private Integer aty;
    @JsonProperty("tfa130") private Integer tfa;
    @JsonProperty("scl130") private Integer scl;
    @JsonProperty("sse130") private Integer sse;
    @JsonProperty("sco130") private String sco;
    @JsonProperty("cht130") private Integer cht;
    @JsonProperty("tfo130") private Integer tfo;
    @JsonProperty("trt130") private BigDecimal trt;
    @JsonProperty("npt130") private String npt;
    @JsonProperty("cdc130")private String cdc;
    @JsonProperty("eml130")private String eml;
    @JsonProperty("ope130")private String ope; 
}