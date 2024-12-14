package com.example.forum_back.sender

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "openai")
class OpenaiProperties {
    lateinit var key: String
}