package com.example.chatgptbasedcookingingredients.dto;

public record ChatGPTMessage(
        String role,
        String content
) {
}