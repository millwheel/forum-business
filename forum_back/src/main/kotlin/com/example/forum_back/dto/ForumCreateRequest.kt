package com.example.forum_back.dto

import jakarta.validation.constraints.NotBlank

data class ForumCreateRequest(
    @field:NotBlank(message = "Title must not be blank")
    val title: String,
    val description: String,
    val author: String
)
