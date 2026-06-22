package com.example.chatgptbasedcookingingredients.dto;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
@Builder
public record ChatGPTRequest(String model, List<ChatGPTRequestMessage> messages) {
}
