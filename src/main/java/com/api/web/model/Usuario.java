package com.api.web.model;

import javax.persistence.*;
import java.util.Date;
//import java.util.List;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="wwa130")
public class Usuario {
    @Id @Column(name = "usr130", length = 50) private String usr;
    public String getUsr() {
		return usr;
	}
	public String getTen() {
		return ten;
	}
	public String getEnt() {
		return ent;
	}
	public String getNam() {
		return nam;
	}
	public String getPss() {
		return pss;
	}
	public BigDecimal getCtry() {
		return ctry;
	}
	public String getPid() {
		return pid;
	}
	public String getChp() {
		return chp;
	}
	public String getIdi() {
		return idi;
	}
	public String getIdt() {
		return idt;
	}
	public String getCtr() {
		return ctr;
	}
	public String getF_add() {
		return f_add;
	}
	public String getPem() {
		return pem;
	}
	public String getCom() {
		return com;
	}
	public String getChg() {
		return chg;
	}
	public Date getDch() {
		return dch;
	}
	public Date getAda() {
		return ada;
	}
	public String getPob() {
		return pob;
	}
	public String getTea() {
		return tea;
	}
	public String getTel() {
		return tel;
	}
	public String getFaa() {
		return faa;
	}
	public String getFax() {
		return fax;
	}
	public String getCkey() {
		return ckey;
	}
	public String getRan() {
		return ran;
	}
	public BigDecimal getChy() {
		return chy;
	}
	public String getInc() {
		return inc;
	}
	public String getSts() {
		return sts;
	}
	public String getAus() {
		return aus;
	}
	public String getLty() {
		return lty;
	}
	public Date getCrd() {
		return crd;
	}
	public String getOff() {
		return off;
	}
	public String getEcc() {
		return ecc;
	}
	public String getAns() {
		return ans;
	}
	public String getQue() {
		return que;
	}
	public String getUlg() {
		return ulg;
	}
	public Date getLli() {
		return lli;
	}
	public String getApp() {
		return app;
	}
	public String getMig() {
		return mig;
	}
	public Date getFir() {
		return fir;
	}
	public String getMus() {
		return mus;
	}
	public Date getMdt() {
		return mdt;
	}
	public Integer getAty() {
		return aty;
	}
	public Integer getTfa() {
		return tfa;
	}
	public Integer getScl() {
		return scl;
	}
	public Integer getSse() {
		return sse;
	}
	public String getSco() {
		return sco;
	}
	public Integer getCht() {
		return cht;
	}
	public Integer getTfo() {
		return tfo;
	}
	public BigDecimal getTrt() {
		return trt;
	}
	public String getNpt() {
		return npt;
	}
	public String getCdc() {
		return cdc;
	}
	public String getEml() {
		return eml;
	}
	public String getOpe() {
		return ope;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public void setEnt(String ent) {
		this.ent = ent;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public void setPss(String pss) {
		this.pss = pss;
	}
	public void setCtry(BigDecimal ctry) {
		this.ctry = ctry;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setChp(String chp) {
		this.chp = chp;
	}
	public void setIdi(String idi) {
		this.idi = idi;
	}
	public void setIdt(String idt) {
		this.idt = idt;
	}
	public void setCtr(String ctr) {
		this.ctr = ctr;
	}
	public void setF_add(String f_add) {
		this.f_add = f_add;
	}
	public void setPem(String pem) {
		this.pem = pem;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public void setChg(String chg) {
		this.chg = chg;
	}
	public void setDch(Date dch) {
		this.dch = dch;
	}
	public void setAda(Date ada) {
		this.ada = ada;
	}
	public void setPob(String pob) {
		this.pob = pob;
	}
	public void setTea(String tea) {
		this.tea = tea;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setFaa(String faa) {
		this.faa = faa;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setCkey(String ckey) {
		this.ckey = ckey;
	}
	public void setRan(String ran) {
		this.ran = ran;
	}
	public void setChy(BigDecimal chy) {
		this.chy = chy;
	}
	public void setInc(String inc) {
		this.inc = inc;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public void setAus(String aus) {
		this.aus = aus;
	}
	public void setLty(String lty) {
		this.lty = lty;
	}
	public void setCrd(Date crd) {
		this.crd = crd;
	}
	public void setOff(String off) {
		this.off = off;
	}
	public void setEcc(String ecc) {
		this.ecc = ecc;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public void setUlg(String ulg) {
		this.ulg = ulg;
	}
	public void setLli(Date lli) {
		this.lli = lli;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public void setMig(String mig) {
		this.mig = mig;
	}
	public void setFir(Date fir) {
		this.fir = fir;
	}
	public void setMus(String mus) {
		this.mus = mus;
	}
	public void setMdt(Date mdt) {
		this.mdt = mdt;
	}
	public void setAty(Integer aty) {
		this.aty = aty;
	}
	public void setTfa(Integer tfa) {
		this.tfa = tfa;
	}
	public void setScl(Integer scl) {
		this.scl = scl;
	}
	public void setSse(Integer sse) {
		this.sse = sse;
	}
	public void setSco(String sco) {
		this.sco = sco;
	}
	public void setCht(Integer cht) {
		this.cht = cht;
	}
	public void setTfo(Integer tfo) {
		this.tfo = tfo;
	}
	public void setTrt(BigDecimal trt) {
		this.trt = trt;
	}
	public void setNpt(String npt) {
		this.npt = npt;
	}
	public void setCdc(String cdc) {
		this.cdc = cdc;
	}
	public void setEml(String eml) {
		this.eml = eml;
	}
	public void setOpe(String ope) {
		this.ope = ope;
	}
	@Column(name = "ten130",nullable = false, length = 20) private String ten;
    @Column(name = "ent130",nullable = false, length = 50) private String ent;
    @Column(name = "nam130",length = 50) private String nam;
    @Column(name = "pss130",length = 50) private String pss;
    @Column(name = "try130", columnDefinition = "decimal", precision = 4, scale = 2) private BigDecimal ctry;
    @Column(name = "pid130", length = 20) private String pid;
    @Column(name = "chp130", columnDefinition = "char(1)") private String chp;
    @Column(name = "idi130", length = 30) private String idi;
    @Column(name = "idt130", length = 3) private String idt;
    @Column(name = "ctr130", length = 3) private String ctr;
    @Column(name = "add130", length = 120) private String f_add;
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
    @Column(name = "key130", columnDefinition = "char(2)") private String ckey;
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
