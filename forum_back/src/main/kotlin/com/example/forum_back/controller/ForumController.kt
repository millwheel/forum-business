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

    @PostMapping("/{forumId}/likes")
    fun increaseLikes(
        @PathVariable forumId: Long,
        @RequestHeader("X-User-Id") userId: Long
    ) {
        forumService.addLike(forumId, userId)
    }

    @DeleteMapping("/{forumId}/likes")
    fun decreaseLikes(
        @PathVariable forumId: Long,
        @RequestHeader("X-User-Id") userId: Long
    ) {
        forumService.removeLike(forumId, userId)
    }

    @DeleteMapping("/{forumId}")
    fun deleteForum(@PathVariable forumId: Long) {
        forumService.deleteForum(forumId)
    }
}