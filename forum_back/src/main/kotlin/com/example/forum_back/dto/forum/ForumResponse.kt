package com.example.forum_back.dto.forum

import com.example.forum_back.entity.User
import com.example.forum_back.entity.forum.Forum

data class ForumResponse (
    val id: Long,
    val title: String,
    val description: String,
    val author: String,
    val likes: Int
) {

    companion object {
        fun of(forum: Forum, user: User): ForumResponse {
            return ForumResponse(
                id = forum.id!!,
                title = forum.title,
                description = forum.description,
                author = user.name,
                likes = forum.likes
            )
        }
    }

}