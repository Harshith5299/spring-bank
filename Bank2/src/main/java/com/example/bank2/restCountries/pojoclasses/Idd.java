package com.example.bank2.restCountries.pojoclasses;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Idd {

   @SerializedName("root")
   String root;

   @SerializedName("suffixes")
   List<String> suffixes;


    public void setRoot(String root) {
        this.root = root;
    }
    public String getRoot() {
        return root;
    }
    
    public void setSuffixes(List<String> suffixes) {
        this.suffixes = suffixes;
    }
    public List<String> getSuffixes() {
        return suffixes;
    }
    
}