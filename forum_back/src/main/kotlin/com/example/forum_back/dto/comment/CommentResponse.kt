package com.example.forum_back.dto.comment

import com.example.forum_back.entity.comment.Comment

data class CommentResponse (
    val id: Long,
    val description: String,
    val author: String
) {
    companion object {
        fun of(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id!!,
                description = comment.description,
                author = comment.author
            )
        }
    }
}