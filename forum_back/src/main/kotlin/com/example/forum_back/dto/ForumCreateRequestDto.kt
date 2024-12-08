package com.example.forum_back.dto

data class ForumCreateRequestDto(
    val title: String,
    val description: String,
    val author: String
)
