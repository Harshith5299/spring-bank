package com.example.bank2.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(value = "spring.datasource")
public class DataSourceConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
