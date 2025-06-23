package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Languages {

   @SerializedName("eng")
   String eng;


    public void setEng(String eng) {
        this.eng = eng;
    }
    public String getEng() {
        return eng;
    }
    
}