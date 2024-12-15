package com.example.forum_back.sender

import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class OpenaiApiSender(
    private val openaiProperties: OpenaiProperties
) {

    private var restClient = RestClient.builder()
        .baseUrl("https://api.openai.com/v1/chat/completions")
        .defaultHeader("Authorization", "Bearer ${openaiProperties.key}")
        .defaultHeader("Content-Type", "application/json")
        .build()

    fun sendTranslateRequest(text: String) {
        val result = restClient.post()
            .body(buildRequestBody(text))
            .retrieve()
            .onStatus({ status -> status.is4xxClientError }) { request, response ->
                throw RuntimeException("Error with code: ${response.statusCode}, with header: ${response.headers}")
            }
            .body(String::class.java)

        println(result)
    }

    private fun buildRequestBody(text: String): ChatCompletionRequest {
        return ChatCompletionRequest(
            model = "gpt-4o-mini",
            messages = listOf(
                ChatMessage(role = "system", content = "You are professional translator. Translate the given text to english"),
                ChatMessage(role = "user", content = text)
            )
        )
    }
}
