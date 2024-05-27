package com.example.openapitest.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestFactory {

    private final static String CHAT_GPT_MODEL = "gpt-3.5-turbo";

    public static Map<String, Object> generateChatGPTRequest(String prompt) {
        List<Map<String, Object>> messages = new ArrayList<>();
        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);
        messages.add(message);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", CHAT_GPT_MODEL);
        requestBody.put("messages", messages);
        requestBody.put("temperature", 0.7);
        return requestBody;
    }
}
