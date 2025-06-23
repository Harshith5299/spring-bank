package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Eng {

   @SerializedName("f")
   String f;

   @SerializedName("m")
   String m;


    public void setF(String f) {
        this.f = f;
    }
    public String getF() {
        return f;
    }
    
    public void setM(String m) {
        this.m = m;
    }
    public String getM() {
        return m;
    }
    
}