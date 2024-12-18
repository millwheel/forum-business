package com.example.forum_back.controller

import com.example.forum_back.dto.ResponseResult
import com.example.forum_back.dto.forum.ForumResponse
import com.example.forum_back.dto.forum.ForumSummaryResponse
import com.example.forum_back.service.ForumService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/forums")
class PublicForumController (
    private val forumService: ForumService
){

    @GetMapping
    fun getAllForums(@RequestParam page: Int): ResponseResult<List<ForumSummaryResponse>> {
        return ResponseResult(forumService.getAllForums(page))
    }

    @GetMapping("/{forumId}")
    fun getForumById(@PathVariable forumId: Long): ForumResponse {
        return forumService.getForumById(forumId)
    }

}