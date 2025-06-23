package com.example.bank2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@Component
public class StartupDisplayConfig implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private AppInfo appInfo;

    @Value("${spring.datasource.url}")
    private String dataSourceConfig;

    @Autowired
    private JpaConfig jpaConfig;

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("=== My Custom Spring Boot Application ===");
        System.out.println("Application has started successfully!");
        System.out.println("Name: " + appInfo.getName());
        System.out.println("Version: " + appInfo.getVersion());
        System.out.println("Data Source Url: " + dataSourceConfig);
        System.out.println("Jpa Open View: " + jpaConfig.getOpenInView());
        System.out.println("Server Address: http://localhost:" + serverProperties.getPort());
        System.out.println("Available Endpoints:");
        System.out.println("  - GET /bank2/helloWorld: Returns a simple 'Hello World' message.");
        System.out.println("  - POST /bank2/createAccount: Provide account details in JSON format to create a new account.");
        System.out.println("  - GET /bank2/retrieveAccount: Provide account ID in JSON format to retrieve account details.");
        System.out.println("  - PUT /bank2/updateAccount: Provide updated account details in JSON format to modify an account.");
        System.out.println("  - DELETE /bank2/deleteAccount: Provide account ID in JSON format to delete an account.");
        System.out.println("  - POST /bank2/depositMoney: Provide account ID and amount in JSON format to deposit money.");
        System.out.println("  - POST /bank2/withdrawMoney: Provide account ID and amount in JSON format to withdraw money.");
        System.out.println("  - POST /bank2/transferMoney: Provide source account ID, target account ID, and amount in JSON format to transfer money.");
    }
}