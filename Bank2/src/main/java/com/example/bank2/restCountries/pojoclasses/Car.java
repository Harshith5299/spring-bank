package com.example.bank2.restCountries.pojoclasses;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Car {

   @SerializedName("signs")
   List<String> signs;

   @SerializedName("side")
   String side;


    public void setSigns(List<String> signs) {
        this.signs = signs;
    }
    public List<String> getSigns() {
        return signs;
    }
    
    public void setSide(String side) {
        this.side = side;
    }
    public String getSide() {
        return side;
    }
    
}