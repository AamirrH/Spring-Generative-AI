package com.code.prodapp.springaitutorial.service;

import com.code.prodapp.springaitutorial.DTOs.PathDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;


    public String getJoke(String topic){

        String systemPrompt = """
            You are a manga/anime fight master explainer.
            Explain me the Kashimo VS Hakari Fight, and give me the why Hakari nearly won.
            """;
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        // Render the Prompt Object Back into a String.
        String renderedText = promptTemplate.render();

//       return chatClient.prompt()
//                // System-Prompt, how the user wants the LLM to behave.
//                .system("You are a professional comedian, directly give the joke instead of other responses")
//                .user("Give me a joke on the topic "+topic) // User-Prompt, what the user wants the LLM to do.
//                .call()
//                .content();
        var response = chatClient.prompt()
                .user(renderedText)
                .call()
                .chatClientResponse();


        return response.chatResponse().getResult().getOutput().getText();

    }

    public String getShortestPath(List<PathDTO> pathDTO){

        String systemPrompt = """
                You are a path prediction model, which you will give the shortest path.
                A List of Path Data-Transfer Object will be provided, comparing the JSON you will return the path that is the most
                favourable (shortest distance and shortest TimeToReach). You will only respond in the Data Transfer Object and nothing else.
                If there are more than one paths then give them.
                Strictly give the response in the form of PathDTO i.e JSON
                These are the List of The Paths {pathDTO}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String renderedText = promptTemplate.render(Map.of("pathDTO", pathDTO));

        var response = chatClient.prompt()
                .user(renderedText)
                .call()
                .chatClientResponse();

        return response.chatResponse().getResult().getOutput().getText();




    }



}
