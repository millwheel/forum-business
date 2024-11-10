package com.example.forum_back.dto

data class ForumRequestDto(
    val title: String,
    val description: String,
    val author: String,
    val category: String
)
