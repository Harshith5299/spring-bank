package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Flags {

   @SerializedName("png")
   String png;

   @SerializedName("svg")
   String svg;


    public void setPng(String png) {
        this.png = png;
    }
    public String getPng() {
        return png;
    }
    
    public void setSvg(String svg) {
        this.svg = svg;
    }
    public String getSvg() {
        return svg;
    }
    
}