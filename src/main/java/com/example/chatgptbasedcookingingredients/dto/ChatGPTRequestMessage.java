package com.example.chatgptbasedcookingingredients.dto;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record ChatGPTRequestMessage(String role, String content) {
}
