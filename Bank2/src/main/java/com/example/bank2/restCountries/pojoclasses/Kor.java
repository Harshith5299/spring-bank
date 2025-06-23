package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Kor {

   @SerializedName("official")
   String official;

   @SerializedName("common")
   String common;


    public void setOfficial(String official) {
        this.official = official;
    }
    public String getOfficial() {
        return official;
    }
    
    public void setCommon(String common) {
        this.common = common;
    }
    public String getCommon() {
        return common;
    }
    
}