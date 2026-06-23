package com.code.prodapp.springaitutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    public String getJoke(String topic){
       return chatClient.prompt()
                .user("Do not start sentences with Heres... Give the Joke directly and only the joke nothing else Give me a joke on the topic "+topic)
                .call()
                .content();
    }

}
