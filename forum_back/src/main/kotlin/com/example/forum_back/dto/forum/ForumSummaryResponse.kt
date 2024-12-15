package com.example.forum_back.dto.forum

import com.example.forum_back.entity.User
import com.example.forum_back.entity.forum.Forum

class ForumSummaryResponse(
    val id: Long,
    val title: String,
    val author: String,
    val likes: Int
) {

    companion object{
        fun of(forum: Forum, user: User): ForumSummaryResponse{
            return ForumSummaryResponse(
                id = forum.id!!,
                title = forum.title,
                author = user.name,
                likes = forum.likes,
            )
        }
    }
}