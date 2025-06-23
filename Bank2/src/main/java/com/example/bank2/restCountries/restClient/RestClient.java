package com.example.bank2.restCountries.restClient;

import com.example.bank2.restCountries.pojoclasses.CountriesDetails;
import com.example.bank2.restCountries.pojoclasses.Currencies;
import com.example.bank2.restCountries.pojoclasses.Name;
import com.example.bank2.restCountries.pojoclasses.SHP;
import com.example.bank2.restCountries.response.CountriesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class RestClient {

    static String url = "https://restcountries.com/v3.1/all";

    @Autowired
    static RestTemplate restTemplate;

    static List<CountriesResponse> responseList = null;

    public static List<CountriesResponse> getAllCountries(){
        restTemplate = new RestTemplate();
        // Create a Request Entity and add headers to the entity
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity=new HttpEntity<>(headers);
        String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(response);

        // format/handle the response

        List<CountriesResponse> list = handleResponse(response);
        return list;

    }


    public static List<CountriesResponse> handleResponse(String response){
        ObjectMapper mapper = new ObjectMapper();
        try {
            responseList = new ArrayList<>();
            List<CountriesDetails> detailsList = mapper.readValue(response, new TypeReference<List<CountriesDetails>>() {
            });
            for(CountriesDetails details : detailsList){
                // Create a new instance of the pojo object and manually assign the fields to prevent null pointer
                // exception (also include not empty condition in case of a collections class based field)
                CountriesResponse countriesResponse = new CountriesResponse();

                Name name = details.getName(); // The field Name has many sub-fields with different names. Thus, we are using the name object
                // to get the appropriate subfield
                if(null!=name) {countriesResponse.setName(name.getCommon());}
                else{countriesResponse.setName("");}

                Currencies currencies = details.getCurrencies();
                if(currencies!=null){
                    SHP shp = currencies.getSHP();
                    if(shp!=null){countriesResponse.setCurrencies(shp.getName());}
                else{countriesResponse.setCurrencies("");}}

                List<String> capitalList = details.getCapital();
                if(capitalList!=null && !capitalList.isEmpty()){
                    for(String capital : capitalList){ //The capital in JSON is in a List String format. So use for-loop
                        // to iterate through the list and only set the last and latest capital
                        countriesResponse.setCapital(capital);
                    }
                }else {countriesResponse.setCapital("");}

                System.out.println(countriesResponse);
                responseList.add(countriesResponse);

            } //End of main for-loop
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return responseList;
        }

}
