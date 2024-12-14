package com.example.forum_back.controller

import com.example.forum_back.dto.ResponseResult
import com.example.forum_back.dto.comment.CommentResponse
import com.example.forum_back.service.CommentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/comments")
class PublicCommentController (
    private val commentService: CommentService
) {

    @GetMapping("/forum/{forumId}")
    fun getCommentsByForumId(@PathVariable forumId: Long): ResponseResult<List<CommentResponse>> {
        return ResponseResult(commentService.getCommentsByForumId(forumId))
    }
}