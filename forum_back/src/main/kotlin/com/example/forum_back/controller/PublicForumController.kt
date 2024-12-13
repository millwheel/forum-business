package com.example.forum_back.controller

import com.example.forum_back.dto.forum.ForumResponse
import com.example.forum_back.service.ForumService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/forums")
class PublicForumController (
    private val forumService: ForumService
){

    @GetMapping
    fun getAllForums(): List<ForumResponse> {
        return forumService.getAllForums().map { ForumResponse.of(it) }
    }

    @GetMapping("/{forumId}")
    fun getForumById(@PathVariable forumId: Long): ForumResponse {
        val forum = forumService.getForumById(forumId)
        return ForumResponse.of(forum)
    }

}