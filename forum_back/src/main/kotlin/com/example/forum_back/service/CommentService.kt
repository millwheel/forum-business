package com.example.forum_back.service

import com.example.forum_back.dto.comment.CommentCreateRequest
import com.example.forum_back.dto.comment.CommentResponse
import com.example.forum_back.dto.comment.CommentUpdateRequest
import com.example.forum_back.entity.comment.Comment
import com.example.forum_back.repository.CommentRepository
import com.example.forum_back.repository.UserRepository
import com.example.forum_back.util.findByIdOrThrow

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService(
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository
) {

    fun getCommentsByForumId(forumId: Long): List<CommentResponse> {
        val comments = commentRepository.findByForumId(forumId)

        return comments.map { comment ->
            val user = userRepository.findByIdOrThrow(comment.authorId)
            CommentResponse.of(comment, user)
        }
    }

    @Transactional
    fun createComment(forumId: Long, commentCreateRequest: CommentCreateRequest): Comment {
        if(!userRepository.existsById(commentCreateRequest.authorId)){
            throw RuntimeException("User Not Found")
        }
        val comment = Comment(commentCreateRequest.description, commentCreateRequest.authorId, forumId)
        commentRepository.save(comment)
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