package com.example.forum_back.controller

import com.example.forum_back.dto.ForumRequestDto
import com.example.forum_back.entity.Forum
import com.example.forum_back.service.ForumService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/forums")
class ForumController(
    private val forumService: ForumService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllForums(): List<Forum> {
        return forumService.getAllForums()
    }

    @GetMapping("/{forumId}")
    @ResponseStatus(HttpStatus.OK)
    fun getForumById(@PathVariable forumId: Long): Forum {
        return forumService.getForumById(forumId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createForum(@RequestBody forumRequestDto: ForumRequestDto) {
        forumService.addForum(forumRequestDto)
    }

    @DeleteMapping("/{forumId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteForum(@PathVariable forumId: Long) {
        forumService.deleteForum(forumId)
    }
}