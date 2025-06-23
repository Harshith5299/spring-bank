package com.example.bank2.controllerTest;

import com.example.bank2.configuration.ServerInfo;
import com.example.bank2.controller.Controller;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest //This annotation allows Spring to use dependency injection inside the testing classes
@RunWith(SpringRunner.class)
public class controllerTest {


    ServerInfo serverInfo;

    @Before
    public void setUp() {
        serverInfo = new ServerInfo();

    }

    private String hostUrl = "http://"+serverInfo.getServerAddress()+":"+serverInfo.getServerPort();

    @Test
    void helloWorldShouldReturnHelloWorld(){
        Controller controller = new Controller();

        String url = hostUrl+"/bank2/helloWorld";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        HttpEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        assertEquals("Hello World", responseEntity.getBody());
        assertEquals("Hello World", controller.helloWorld());

    }

}
