package com.example.bank2.restCountries.pojoclasses;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class CapitalInfo {

   @SerializedName("latlng")
   List<Double> latlng;


    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }
    public List<Double> getLatlng() {
        return latlng;
    }
    
}