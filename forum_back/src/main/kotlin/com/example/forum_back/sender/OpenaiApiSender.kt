package com.example.forum_back.sender

import org.springframework.stereotype.Component


@Component
class OpenaiApiSender (
    private val openaiProperties: OpenaiProperties
){
    private val apiKey = openaiProperties.key

    fun sendRequestToOpenAI(payload: String) {
        println("payload: $payload")
        println("Using API Key: $apiKey")
        // TODO OpenAI API 호출 로직 작성
    }

}