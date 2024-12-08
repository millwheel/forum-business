package com.example.forum_back.controller

import com.example.forum_back.dto.forum.ForumCreateRequest
import com.example.forum_back.dto.forum.ForumResponse
import com.example.forum_back.dto.forum.ForumUpdateRequest
import com.example.forum_back.service.ForumService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/forums")
class ForumController(
    private val forumService: ForumService
) {

    @GetMapping
    fun getAllForums(): List<ForumResponse> {
        return forumService.getAllForums().map { ForumResponse.of(it) }
    }

    @GetMapping("/{forumId}")
    fun getForumById(@PathVariable forumId: Long): ForumResponse {
        val forum = forumService.getForumById(forumId)
        return ForumResponse.of(forum)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createForum(@RequestBody @Valid forumCreateRequest: ForumCreateRequest) {
        forumService.createForum(forumCreateRequest)
    }

    @PutMapping("/{forumId}")
    fun updateForum(@PathVariable forumId: Long,
                    @RequestBody forumUpdateRequest: ForumUpdateRequest
    ) {
        forumService.updateForum(forumId, forumUpdateRequest)
    }

    @DeleteMapping("/{forumId}")
    fun deleteForum(@PathVariable forumId: Long) {
        forumService.deleteForum(forumId)
    }
}