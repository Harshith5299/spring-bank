package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Maps {

   @SerializedName("googleMaps")
   String googleMaps;

   @SerializedName("openStreetMaps")
   String openStreetMaps;


    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }
    public String getGoogleMaps() {
        return googleMaps;
    }
    
    public void setOpenStreetMaps(String openStreetMaps) {
        this.openStreetMaps = openStreetMaps;
    }
    public String getOpenStreetMaps() {
        return openStreetMaps;
    }
    
}