package com.example.forum_back.dto.comment

data class CommentCreateRequest (
    val description: String,
    val authorId: Long
)