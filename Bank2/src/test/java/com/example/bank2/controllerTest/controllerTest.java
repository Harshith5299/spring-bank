package com.example.bank2.controllerTest;

import com.example.bank2.configuration.ServerInfo;
import com.example.bank2.controller.Controller;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class controllerTest {

    ServerInfo serverInfo;

    @BeforeEach
    public void setUp() {
        serverInfo = new ServerInfo();
    }

    private String hostUrl;

    @Test
    void helloWorldShouldReturnHelloWorld() {
        hostUrl = "http://" + serverInfo.getServerAddress() + ":" + serverInfo.getServerPort();
        Controller controller = new Controller();

        String url = hostUrl + "/bank2/helloWorld";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        HttpEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        assertEquals("Hello World", responseEntity.getBody());
        assertEquals("Hello World", controller.helloWorld());
    }
}