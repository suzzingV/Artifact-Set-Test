package com.example.openapitest.domain.chatGPT.application;

import com.example.openapitest.core.config.ChatGptConfig;
import com.example.openapitest.factory.RequestFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGptService {

    private final ChatGptConfig chatGptConfig;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public ChatGptService(ChatGptConfig chatGptConfig) {
        this.chatGptConfig = chatGptConfig;
    }

    public String getAnswer(String prompt) {
        Map<String, Object> requestBody = RequestFactory.generateChatGPTRequest(prompt);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, chatGptConfig.httpHeaders());

        ResponseEntity<Map> response = chatGptConfig.restTemplate().exchange(API_URL, HttpMethod.POST, entity, Map.class);

        return extractAnswer(response);
    }

    private String extractAnswer(ResponseEntity<Map> response) {
        if(response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null) {
                List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
                if (!choices.isEmpty()) {
                    Map<String, Object> firstChoice = choices.get(0);
                    Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");

                    return (String) message.get("content");
                }
            }
        }
        return null;
    }
}
