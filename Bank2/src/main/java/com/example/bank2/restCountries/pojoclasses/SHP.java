package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class SHP {

   @SerializedName("name")
   String name;

   @SerializedName("symbol")
   String symbol;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
    
}