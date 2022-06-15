package com.api.web.model;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @Column(length = 50)
    private String usr;
    @Column(nullable = false, length = 20)
    private String ten;
    @Column(nullable = false, length = 50)
    private String ent;
    @Column(length = 50)
    private String nam;
    private String pss;

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEnt() {
        return ent;
    }

    public void setEnt(String ent) {
        this.ent = ent;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getPss() {
        return pss;
    }

    public void setPss(String pss) {
        this.pss = pss;
    }

    public BigDecimal getCtry() {
        return ctry;
    }

    public void setCtry(BigDecimal ctry) {
        this.ctry = ctry;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getChp() {
        return chp;
    }

    public void setChp(String chp) {
        this.chp = chp;
    }

    public String getIdi() {
        return idi;
    }

    public void setIdi(String idi) {
        this.idi = idi;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPem() {
        return pem;
    }

    public void setPem(String pem) {
        this.pem = pem;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getChg() {
        return chg;
    }

    public void setChg(String chg) {
        this.chg = chg;
    }

    public Date getDch() {
        return dch;
    }

    public void setDch(Date dch) {
        this.dch = dch;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFaa() {
        return faa;
    }

    public void setFaa(String faa) {
        this.faa = faa;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getRan() {
        return ran;
    }

    public void setRan(String ran) {
        this.ran = ran;
    }

    public BigDecimal getChy() {
        return chy;
    }

    public void setChy(BigDecimal chy) {
        this.chy = chy;
    }

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getAus() {
        return aus;
    }

    public void setAus(String aus) {
        this.aus = aus;
    }

    public Date getAda() {
        return ada;
    }

    public void setAda(Date ada) {
    	System.out.println(ada);
        this.ada = ada;
    }

    public String getLty() {
        return lty;
    }

    public void setLty(String lty) {
        this.lty = lty;
    }

    public Date getCrd() {
        return crd;
    }

    public void setCrd(Date crd) {
        this.crd = crd;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    public String getEcc() {
        return ecc;
    }

    public void setEcc(String ecc) {
        this.ecc = ecc;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getUlg() {
        return ulg;
    }

    public void setUlg(String ulg) {
        this.ulg = ulg;
    }

    public Date getLli() {
        return lli;
    }

    public void setLli(Date lli) {
        this.lli = lli;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getMig() {
        return mig;
    }

    public void setMig(String mig) {
        this.mig = mig;
    }

    public Date getFir() {
        return fir;
    }

    public void setFir(Date fir) {
        this.fir = fir;
    }

    public String getMus() {
        return mus;
    }

    public void setMus(String mus) {
        this.mus = mus;
    }

    public Date getMdt() {
        return mdt;
    }

    public void setMdt(Date mdt) {
        this.mdt = mdt;
    }

    public Integer getAty() {
        return aty;
    }

    public void setAty(Integer aty) {
        this.aty = aty;
    }

    public Integer getTfa() {
        return tfa;
    }

    public void setTfa(Integer tfa) {
        this.tfa = tfa;
    }

    public Integer getScl() {
        return scl;
    }

    public void setScl(Integer scl) {
        this.scl = scl;
    }

    public Integer getSse() {
        return sse;
    }

    public void setSse(Integer sse) {
        this.sse = sse;
    }

    public String getSco() {
        return sco;
    }

    public void setSco(String sco) {
        this.sco = sco;
    }

    public Integer getCht() {
        return cht;
    }

    public void setCht(Integer cht) {
        this.cht = cht;
    }

    public Integer getTfo() {
        return tfo;
    }

    public void setTfo(Integer tfo) {
        this.tfo = tfo;
    }

    public BigDecimal getTrt() {
        return trt;
    }

    public void setTrt(BigDecimal trt) {
        this.trt = trt;
    }

    public String getNpt() {
        return npt;
    }

    public void setNpt(String npt) {
        this.npt = npt;
    }

    public String getCdc() {
        return cdc;
    }

    public void setCdc(String cdc) {
        this.cdc = cdc;
    }

    public String getEml() {
        return eml;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public String getOpe() {
        return ope;
    }

    public void setOpe(String ope) {
        this.ope = ope;
    }

    @Column(name = "try", columnDefinition = "decimal", precision = 4, scale = 2)
    private BigDecimal ctry;
    @Column(length = 20)
    private String pid;
    @Column(columnDefinition = "char(1)")
    private String chp;
    @Column(length = 30)
    private String idi;
    @Column(length = 3)
    private String idt;
    @Column(length = 3)
    private String ctr;
    @Column(length = 120)
    private String add;
    @Column(length = 80,unique=true)
    private String pem;
    @Column(length = 100)
    private String com;
    @Column(columnDefinition = "char(1)")
    private String chg;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dch;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ada;
    @Column(columnDefinition = "char(5)")
    private String pob;
    @Column(columnDefinition = "char(3)")
    private String tea;
    @Column(columnDefinition = "char(10)")
    private String tel;
    @Column(columnDefinition = "char(3)")
    private String faa;
    @Column(columnDefinition = "char(10)")
    private String fax;
    @Column(name = "ckey", columnDefinition = "char(2)")
    private String ckey;
    @Column(columnDefinition = "char(8)")
    private String ran;
    @Column(columnDefinition = "decimal", precision = 5, scale = 2)
    private BigDecimal chy;
    @Column(columnDefinition = "char(2)")
    private String inc;
    @Column(columnDefinition = "char(3)")
    private String sts;
    @Column(columnDefinition = "char(50)")
    private String aus;
    @Column(columnDefinition = "char(1)")
    private String lty;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date crd;
    @Column(columnDefinition = "char(1) DEFAULT '0'")
    private String off;
    @Column(columnDefinition = "char(1) DEFAULT '0'")
    private String ecc;
    private String ans = "";
    private String que = "";
    @Column(columnDefinition = "char(4) DEFAULT ''")
    private String ulg;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lli;
    @Column(columnDefinition = "char(1) DEFAULT '2'")
    private String app;
    @Column(columnDefinition = "char(1) DEFAULT '0'")
    private String mig;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fir;
    @Column(columnDefinition = "char(50)")
    private String mus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdt;
    @Column(columnDefinition = "SMALLINT")
    private Integer aty;
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private Integer tfa;
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private Integer scl;
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private Integer sse;
    @Column(columnDefinition = "char(1) DEFAULT 'L'")
    private String sco;
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private Integer cht;
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private Integer tfo;
    @Column(columnDefinition = "decimal", precision = 4, scale = 2)
    private BigDecimal trt;
    @Column(columnDefinition = "char(1) DEFAULT 'S'")
    private String npt;
    @Column(columnDefinition = "char(3)")
    private String cdc;
    @Column(columnDefinition = "char(80)")
    private String eml;
    @Column(columnDefinition = "char(2)")
    private String ope;
}
