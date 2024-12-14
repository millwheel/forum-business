package com.example.forum_back.controller

import com.example.forum_back.dto.comment.CommentCreateRequest
import com.example.forum_back.dto.comment.CommentUpdateRequest
import com.example.forum_back.service.CommentService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(
    private val commentService: CommentService
) {

    @PostMapping("/forum/{forumId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun createComment(
        @PathVariable forumId: Long,
        @Valid @RequestBody commentCreateRequest: CommentCreateRequest
    ) {
        commentService.createComment(forumId, commentCreateRequest)
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable commentId: Long,
        @Valid @RequestBody commentUpdateRequest: CommentUpdateRequest
    ) {
        commentService.updateComment(commentId, commentUpdateRequest)
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long) {
        commentService.deleteComment(commentId)
    }
}