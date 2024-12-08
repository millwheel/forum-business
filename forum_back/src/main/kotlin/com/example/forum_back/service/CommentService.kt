package com.example.forum_back.service

import com.example.forum_back.dto.comment.CommentCreateRequest
import com.example.forum_back.dto.comment.CommentUpdateRequest
import com.example.forum_back.entity.Comment
import com.example.forum_back.repository.CommentRepository
import com.example.forum_back.util.findByIdOrThrow

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService(
    private val commentRepository: CommentRepository
) {

    fun getCommentsByForumId(forumId: Long): List<Comment> {
        if (!commentRepository.existsByForumId(forumId)) {
            throw IllegalArgumentException("Forum with id: $forumId does not exist.")
        }
        return commentRepository.findByForumId(forumId)
    }

    @Transactional
    fun createComment(forumId: Long, commentCreateRequest: CommentCreateRequest): Comment {
        val comment = Comment(
            description = commentCreateRequest.description,
            author = commentCreateRequest.author,
            forumId = forumId
        )
        return commentRepository.save(comment)
    }

    @Transactional
    fun updateComment(commentId: Long, commentUpdateRequest: CommentUpdateRequest): Comment {
        val comment = commentRepository.findByIdOrThrow(commentId)
        comment.updateComment(commentUpdateRequest)
        return commentRepository.save(comment)
    }

    @Transactional
    fun deleteComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }
}