package com.example.forum_back.entity

import com.example.forum_back.dto.ForumUpdateRequest
import jakarta.persistence.*
import jakarta.persistence.GenerationType.*

@Entity
@Table(name = "forum")
class Forum constructor(
    var title: String,
    var description: String,
    var author: String,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    init {
        if (this.title.isBlank()) {
            throw IllegalArgumentException("title cannot be blank")
        }
    }

    fun updateForum(forumUpdateRequest: ForumUpdateRequest){
        this.title = forumUpdateRequest.title;
        this.description = forumUpdateRequest.description;
    }

}