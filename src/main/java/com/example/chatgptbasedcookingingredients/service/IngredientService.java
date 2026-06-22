package com.example.chatgptbasedcookingingredients.service;

import com.example.chatgptbasedcookingingredients.dto.ChatGPTRequest;
import com.example.chatgptbasedcookingingredients.dto.ChatGPTRequestMessage;
import com.example.chatgptbasedcookingingredients.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class IngredientService {

    private final RestClient chatGPTRestClient;

    public IngredientService(@Qualifier("ChatGPTRestClient") RestClient restClient) {
        this.chatGPTRestClient = restClient;
    }

    public String getIngredient(@RequestBody String ingredient) {
        ChatGPTResponse response = this.chatGPTRestClient.post()
                .body(new ChatGPTRequest("gpt-4o-mini", List.of(new ChatGPTRequestMessage("user", "Beatworte die Frage bitte in einem Wort. Beziehe dich nur auf vegan oder nicht vegan. Folgende frage soll beantwortet werden: " + ingredient))))
                .retrieve()
                .body(ChatGPTResponse.class);

        return response.text();
    }
}
