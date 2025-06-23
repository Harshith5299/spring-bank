package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Currencies {

   @SerializedName("SHP")
   SHP SHP;


    public void setSHP(SHP SHP) {
        this.SHP = SHP;
    }
    public SHP getSHP() {
        return SHP;
    }
    
}