package com.ia.interfaces;

// Un Record genera automaticamente getters, toString, equals y hashCode de forma inmutable
public record PromptInput(String systemPrompt, String userQuery) {
}
