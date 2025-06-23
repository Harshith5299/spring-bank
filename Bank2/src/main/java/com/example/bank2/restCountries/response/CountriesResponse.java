package com.example.bank2.restCountries.response;
import java.util.List;

import com.example.bank2.restCountries.pojoclasses.Currencies;
import com.example.bank2.restCountries.pojoclasses.Name;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountriesResponse {

   @SerializedName("name")
   private String name;

   @SerializedName("currencies")
   private String currencies;

   @SerializedName("capital")
   private String capital;

}