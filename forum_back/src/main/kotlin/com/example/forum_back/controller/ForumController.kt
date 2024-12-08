package com.example.forum_back.controller

import com.example.forum_back.dto.ForumCreateRequest
import com.example.forum_back.dto.ForumResponse
import com.example.forum_back.dto.ForumUpdateRequest
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
    fun getAllForums(): List<ForumResponse> {
        return forumService.getAllForums().map { ForumResponse.of(it) }
    }

    @GetMapping("/{forumId}")
    @ResponseStatus(HttpStatus.OK)
    fun getForumById(@PathVariable forumId: Long): ForumResponse {
        val forum = forumService.getForumById(forumId)
        return ForumResponse.of(forum)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createForum(@RequestBody forumCreateRequest: ForumCreateRequest) {
        forumService.createForum(forumCreateRequest)
    }

    @PutMapping("/{forumId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateForum(@PathVariable forumId: Long,
                    @RequestBody forumUpdateRequest: ForumUpdateRequest) {
        forumService.updateForum(forumId, forumUpdateRequest)
    }

    @DeleteMapping("/{forumId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteForum(@PathVariable forumId: Long) {
        forumService.deleteForum(forumId)
    }
}