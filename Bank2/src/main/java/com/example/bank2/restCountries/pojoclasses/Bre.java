package com.example.bank2.restCountries.pojoclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class Bre {

   @SerializedName("official")
   String official;

   @SerializedName("common")
   String common;

}