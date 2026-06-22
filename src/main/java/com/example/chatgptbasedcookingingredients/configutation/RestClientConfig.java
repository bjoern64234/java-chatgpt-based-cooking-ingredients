package com.example.chatgptbasedcookingingredients.configutation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient ChatGPTRestClient(@Value("${API_KEY}") String API_KEY) {
        return RestClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + API_KEY)
                .build();
    }
}