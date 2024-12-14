package com.example.forum_back.dto.forum

import com.example.forum_back.entity.forum.Forum

class ForumSummaryResponse(
    val id: Long,
    val title: String,
    val author: String
) {

    companion object{
        fun of(forum: Forum): ForumSummaryResponse{
            return ForumSummaryResponse(
                id = forum.id!!,
                title = forum.title,
                author = forum.author
            )
        }
    }
}