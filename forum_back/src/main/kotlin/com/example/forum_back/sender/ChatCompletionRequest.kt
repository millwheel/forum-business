package com.example.forum_back.sender

data class ChatCompletionRequest(
    val model: String,
    val messages: List<ChatMessage>
)