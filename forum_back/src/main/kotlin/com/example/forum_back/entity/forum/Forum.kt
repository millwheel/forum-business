package com.example.forum_back.entity.forum

import com.example.forum_back.dto.forum.ForumUpdateRequest
import com.example.forum_back.entity.BaseTime
import jakarta.persistence.*
import jakarta.persistence.GenerationType.*

@Entity
@Table(name = "forum")
class Forum constructor(
    var title: String,
    var description: String,
    var authorId: Long,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) : BaseTime() {

    init {
        if (this.title.isBlank()) {
            throw IllegalArgumentException("title cannot be blank")
        }
    }

    fun updateForum(forumUpdateRequest: ForumUpdateRequest){
        this.title = forumUpdateRequest.title
        this.description = forumUpdateRequest.description
    }

}