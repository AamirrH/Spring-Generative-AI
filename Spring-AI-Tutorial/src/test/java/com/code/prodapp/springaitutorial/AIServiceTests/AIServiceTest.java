package com.code.prodapp.springaitutorial.AIServiceTests;

import com.code.prodapp.springaitutorial.DTOs.PathDTO;
import com.code.prodapp.springaitutorial.service.AIService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AIServiceTest {

    @Autowired
   private AIService service;
    List<PathDTO> pathDTOList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        pathDTOList.add(new PathDTO(1L,234.5,2445.4));
        pathDTOList.add(new PathDTO(2L,232.5,244.4));
    }


//    @Test
//    void getTestJoke(){
//        System.out.println(service.getJoke("Shawarma"));
//    }

    @Test
    void getShortestPath(){
        System.out.println(service.getShortestPath(pathDTOList).toString());
    }


}

