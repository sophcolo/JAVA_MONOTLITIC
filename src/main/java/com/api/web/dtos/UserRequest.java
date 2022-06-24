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
    @JsonProperty("usr") private String usr;
    @JsonProperty("ten") private String ten;
    @JsonProperty("ent") private String ent;
    @JsonProperty("nam") private String nam;
    @JsonProperty("pss") private String pss;
    @JsonProperty("f_try") private BigDecimal f_try;
    @JsonProperty("pid") private String pid;
    @JsonProperty("chp") private String chp;
    @JsonProperty("idi") private String idi;
    @JsonProperty("idt") private String idt;
    @JsonProperty("ctr") private String ctr;
    @JsonProperty("add") private String add;
    @JsonProperty("pem") private String pem;
    @JsonProperty("com") private String com;
    @JsonProperty("chg") private String chg;
    @JsonProperty("dch") private Date dch;
    @JsonProperty("ada") private Date ada;
    @JsonProperty("pob") private String pob;
    @JsonProperty("tea") private String tea;
    @JsonProperty("tel") private String tel;
    @JsonProperty("faa") private String faa;
    @JsonProperty("fax") private String fax;
    @JsonProperty("key") private String key;
    @JsonProperty("ran") private String ran;
    @JsonProperty("chy") private BigDecimal chy;
    @JsonProperty("inc") private String inc;
    @JsonProperty("sts") private String sts;
    @JsonProperty("aus") private String aus;
    @JsonProperty("lty") private String lty;
    @JsonProperty("crd") private Date crd;
    @JsonProperty("off") private String off;
    @JsonProperty("ecc") private String ecc;
    @JsonProperty("ans") private String ans;
    @JsonProperty("que") private String que;
    @JsonProperty("ulg") private String ulg;
    @JsonProperty("lli") private Date lli;
    @JsonProperty("app") private String app;
    @JsonProperty("mig") private String mig;
    @JsonProperty("fir") private Date fir;
    @JsonProperty("mus") private String mus;
    @JsonProperty("mdt") private Date mdt;
    @JsonProperty("aty") private Integer aty;
    @JsonProperty("tfa") private Integer tfa;
    @JsonProperty("scl") private Integer scl;
    @JsonProperty("sse") private Integer sse;
    @JsonProperty("sco") private String sco;
    @JsonProperty("cht") private Integer cht;
    @JsonProperty("tfo") private Integer tfo;
    @JsonProperty("trt") private BigDecimal trt;
    @JsonProperty("npt") private String npt;
    @JsonProperty("cdc")private String cdc;
    @JsonProperty("eml")private String eml;
    @JsonProperty("ope")private String ope;  
}