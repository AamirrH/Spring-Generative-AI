package com.code.prodapp.springaitutorial.AIServiceTests;

import com.code.prodapp.springaitutorial.service.AIService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {

    @Autowired
   private AIService service;

    @Test
    void getTestJoke(){
        System.out.println(service.getJoke("Shawarma"));
    }


}

