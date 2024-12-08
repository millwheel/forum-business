package com.example.forum_back.dto.forum

import com.example.forum_back.entity.Forum

data class ForumResponse (
    val id: Long,
    val title: String,
    val description: String,
    val author: String
) {

    companion object {
        fun of(forum: Forum): ForumResponse {
            return ForumResponse(
                id = forum.id!!,
                title = forum.title,
                description = forum.description,
                author = forum.author
            )
        }
    }

}