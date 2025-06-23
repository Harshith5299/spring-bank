package com.example.bank2.restCountries.pojoclasses;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignores extra fields in a Json response for an application to prevent errors
public class CountriesDetails {

    @SerializedName("name")
    Name name;

    @SerializedName("tld")
    List<String> tld;

    @SerializedName("cca2")
    String cca2;

    @SerializedName("ccn3")
    String ccn3;

    @SerializedName("cca3")
    String cca3;

    @SerializedName("independent")
    boolean independent;

    @SerializedName("status")
    String status;

    @SerializedName("unMember")
    boolean unMember;

    @SerializedName("currencies")
    Currencies currencies;

    @SerializedName("idd")
    Idd idd;

    @SerializedName("capital")
    List<String> capital;

    @SerializedName("altSpellings")
    List<String> altSpellings;

    @SerializedName("region")
    String region;

    @SerializedName("languages")
    Languages languages;

    @SerializedName("translations")
    Translations translations;

    @SerializedName("latlng")
    List<Double> latlng;

    @SerializedName("landlocked")
    boolean landlocked;

    @SerializedName("area")
    int area;

    @SerializedName("demonyms")
    Demonyms demonyms;

    @SerializedName("flag")
    String flag;

    @SerializedName("maps")
    Maps maps;

    @SerializedName("population")
    int population;

    @SerializedName("car")
    Car car;

    @SerializedName("timezones")
    List<String> timezones;

    @SerializedName("continents")
    List<String> continents;

    @SerializedName("flags")
    Flags flags;

    @SerializedName("coatOfArms")
    CoatOfArms coatOfArms;

    @SerializedName("startOfWeek")
    String startOfWeek;

    @SerializedName("capitalInfo")
    CapitalInfo capitalInfo;

}