package com.api.web.model;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="wwa130")
public class Usuario {
	@Id @Column(name = "usr130", length = 50) private String usr;
    @Column(name = "ten130",nullable = false, length = 20) private String ten;
    @Column(name = "ent130",nullable = false, length = 50) private String ent;
    @Column(name = "nam130",length = 50) private String nam;
    @Column(name = "pss130",length = 50) private String pss;
    @Column(name = "try130", columnDefinition = "decimal", precision = 4, scale = 2) private BigDecimal f_try;
    @Column(name = "pid130", length = 20) private String pid;
    @Column(name = "chp130", columnDefinition = "char(1)") private String chp;
    @Column(name = "idi130", length = 30) private String idi;
    @Column(name = "idt130", length = 3) private String idt;
    @Column(name = "ctr130", length = 3) private String ctr;
    @Column(name = "add130", length = 120) private String add;
    @Column(name = "pem130", length = 80,unique=true) private String pem;
    @Column(name = "com130", length = 100) private String com;
    @Column(name = "chg130",columnDefinition = "char(1)") private String chg;
    @Column(name = "dch130") @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date dch;
    @Column(name = "ada130") @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date ada;
    @Column(name = "pob130",columnDefinition = "char(5)") private String pob;
    @Column(name = "tea130",columnDefinition = "char(3)") private String tea;
    @Column(name = "tel130",columnDefinition = "char(10)") private String tel;
    @Column(name = "faa130",columnDefinition = "char(3)") private String faa;
    @Column(name = "fax130",columnDefinition = "char(10)") private String fax;
    @Column(name = "key130", columnDefinition = "char(2)") private String key;
    @Column(name = "ran130", columnDefinition = "char(8)") private String ran;
    @Column(name = "chy130", columnDefinition = "decimal", precision = 5, scale = 2) private BigDecimal chy;
    @Column(name = "inc130", columnDefinition = "char(2)") private String inc;
    @Column(name = "sts130", columnDefinition = "char(3)") private String sts;
    @Column(name = "aus130", columnDefinition = "char(50)") private String aus;
    @Column(name = "lty130", columnDefinition = "char(1)") private String lty;
    @Temporal(TemporalType.TIMESTAMP) @Column(name = "crd130", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Date crd;
    @Column(name = "off130", columnDefinition = "char(1) DEFAULT '0'") private String off;
    @Column(name = "ecc130", columnDefinition = "char(1) DEFAULT '0'") private String ecc;
    @Column(name = "ans130") private String ans = "";
    @Column(name = "que130") private String que = "";
    @Column(name = "ulg130",columnDefinition = "char(4) DEFAULT ''") private String ulg;
    @Temporal(TemporalType.TIMESTAMP) @Column(name = "lli130")  private Date lli;
    @Column(name = "app130",columnDefinition = "char(1) DEFAULT '2'") private String app;
    @Column(name = "mig130",columnDefinition = "char(1) DEFAULT '0'") private String mig;
    @Temporal(TemporalType.TIMESTAMP) @Column(name = "fir130") private Date fir;
    @Column(name = "mus130", columnDefinition = "char(50)") private String mus;
    @Temporal(TemporalType.TIMESTAMP) @Column(name = "mdt130") private Date mdt;
    @Column(name = "aty130",columnDefinition = "SMALLINT") private Integer aty;
    @Column(name = "tfa130",columnDefinition = "SMALLINT DEFAULT 0") private Integer tfa;
    @Column(name = "scl130",columnDefinition = "SMALLINT DEFAULT 0") private Integer scl;
    @Column(name = "sse130",columnDefinition = "SMALLINT DEFAULT 0") private Integer sse;
    @Column(name = "sco130",columnDefinition = "char(1) DEFAULT 'L'") private String sco;
    @Column(name = "cht130",columnDefinition = "SMALLINT DEFAULT 0") private Integer cht;
    @Column(name = "tfo130",columnDefinition = "SMALLINT DEFAULT 0") private Integer tfo;
    @Column(name = "trt130",columnDefinition = "decimal", precision = 4, scale = 2) private BigDecimal trt;
    @Column(name = "npt130",columnDefinition = "char(1) DEFAULT 'S'") private String npt;
    @Column(name = "cdc130",columnDefinition = "char(3)") private String cdc;
    @Column(name = "eml130",columnDefinition = "char(80)") private String eml;
    @Column(name = "ope130",columnDefinition = "char(2)") private String ope;
}
