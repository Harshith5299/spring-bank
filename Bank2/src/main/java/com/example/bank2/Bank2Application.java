package com.example.bank2;

import com.example.bank2.restCountries.restClient.RestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class Bank2Application {
    // public class Bank2Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Bank2Application.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        RestClient.getAllCountries();
//    }
}
