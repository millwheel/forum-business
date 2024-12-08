package com.example.forum_back.dto

data class ForumCreateRequest(
    val title: String,
    val description: String,
    val author: String
)
