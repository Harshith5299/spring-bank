package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Translations {

   @SerializedName("ara")
   Ara ara;

   @SerializedName("bre")
   Bre bre;

   @SerializedName("ces")
   Ces ces;

   @SerializedName("cym")
   Cym cym;

   @SerializedName("deu")
   Deu deu;

   @SerializedName("est")
   Est est;

   @SerializedName("fin")
   Fin fin;

   @SerializedName("fra")
   Fra fra;

   @SerializedName("hrv")
   Hrv hrv;

   @SerializedName("hun")
   Hun hun;

   @SerializedName("ita")
   Ita ita;

   @SerializedName("jpn")
   Jpn jpn;

   @SerializedName("kor")
   Kor kor;

   @SerializedName("nld")
   Nld nld;

   @SerializedName("per")
   Per per;

   @SerializedName("pol")
   Pol pol;

   @SerializedName("por")
   Por por;

   @SerializedName("rus")
   Rus rus;

   @SerializedName("slk")
   Slk slk;

   @SerializedName("spa")
   Spa spa;

   @SerializedName("srp")
   Srp srp;

   @SerializedName("swe")
   Swe swe;

   @SerializedName("tur")
   Tur tur;

   @SerializedName("urd")
   Urd urd;

   @SerializedName("zho")
   Zho zho;


    public void setAra(Ara ara) {
        this.ara = ara;
    }
    public Ara getAra() {
        return ara;
    }
    
    public void setBre(Bre bre) {
        this.bre = bre;
    }
    public Bre getBre() {
        return bre;
    }
    
    public void setCes(Ces ces) {
        this.ces = ces;
    }
    public Ces getCes() {
        return ces;
    }
    
    public void setCym(Cym cym) {
        this.cym = cym;
    }
    public Cym getCym() {
        return cym;
    }
    
    public void setDeu(Deu deu) {
        this.deu = deu;
    }
    public Deu getDeu() {
        return deu;
    }
    
    public void setEst(Est est) {
        this.est = est;
    }
    public Est getEst() {
        return est;
    }
    
    public void setFin(Fin fin) {
        this.fin = fin;
    }
    public Fin getFin() {
        return fin;
    }
    
    public void setFra(Fra fra) {
        this.fra = fra;
    }
    public Fra getFra() {
        return fra;
    }
    
    public void setHrv(Hrv hrv) {
        this.hrv = hrv;
    }
    public Hrv getHrv() {
        return hrv;
    }
    
    public void setHun(Hun hun) {
        this.hun = hun;
    }
    public Hun getHun() {
        return hun;
    }
    
    public void setIta(Ita ita) {
        this.ita = ita;
    }
    public Ita getIta() {
        return ita;
    }
    
    public void setJpn(Jpn jpn) {
        this.jpn = jpn;
    }
    public Jpn getJpn() {
        return jpn;
    }
    
    public void setKor(Kor kor) {
        this.kor = kor;
    }
    public Kor getKor() {
        return kor;
    }
    
    public void setNld(Nld nld) {
        this.nld = nld;
    }
    public Nld getNld() {
        return nld;
    }
    
    public void setPer(Per per) {
        this.per = per;
    }
    public Per getPer() {
        return per;
    }
    
    public void setPol(Pol pol) {
        this.pol = pol;
    }
    public Pol getPol() {
        return pol;
    }
    
    public void setPor(Por por) {
        this.por = por;
    }
    public Por getPor() {
        return por;
    }
    
    public void setRus(Rus rus) {
        this.rus = rus;
    }
    public Rus getRus() {
        return rus;
    }
    
    public void setSlk(Slk slk) {
        this.slk = slk;
    }
    public Slk getSlk() {
        return slk;
    }
    
    public void setSpa(Spa spa) {
        this.spa = spa;
    }
    public Spa getSpa() {
        return spa;
    }
    
    public void setSrp(Srp srp) {
        this.srp = srp;
    }
    public Srp getSrp() {
        return srp;
    }
    
    public void setSwe(Swe swe) {
        this.swe = swe;
    }
    public Swe getSwe() {
        return swe;
    }
    
    public void setTur(Tur tur) {
        this.tur = tur;
    }
    public Tur getTur() {
        return tur;
    }
    
    public void setUrd(Urd urd) {
        this.urd = urd;
    }
    public Urd getUrd() {
        return urd;
    }
    
    public void setZho(Zho zho) {
        this.zho = zho;
    }
    public Zho getZho() {
        return zho;
    }
    
}