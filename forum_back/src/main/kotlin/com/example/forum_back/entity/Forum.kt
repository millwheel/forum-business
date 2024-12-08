package com.example.forum_back.entity

import com.example.forum_back.dto.ForumUpdateRequestDto
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
        if (title.isBlank()) {
            throw IllegalArgumentException("title cannot be blank")
        }
    }

    fun updateForum(forumUpdateRequestDto: ForumUpdateRequestDto){
        this.title = forumUpdateRequestDto.title;
        this.description = forumUpdateRequestDto.description;
    }

}