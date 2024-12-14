package com.example.forum_back.entity.comment

import com.example.forum_back.dto.comment.CommentUpdateRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class Comment (
    var description: String,
    var author: String,
    val forumId: Long,
    var imageId: Long?,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    fun updateComment(commentUpdateRequest: CommentUpdateRequest){
        description = commentUpdateRequest.description
    }

    fun updateImage(imageId: Long){
        this.imageId = imageId
    }
}