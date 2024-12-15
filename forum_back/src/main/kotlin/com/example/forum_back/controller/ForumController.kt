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

    @PostMapping("/{id}/likes")
    fun increaseLikes(
        @PathVariable id: Long,
        @RequestHeader("X-User-Id") userId: Long
    ) {
        forumService.addLike(id, userId)
    }

    @DeleteMapping("/{id}/likes")
    fun decreaseLikes(
        @PathVariable id: Long,
        @RequestHeader("X-User-Id") userId: Long
    ) {
        forumService.removeLike(id, userId)
    }

    @DeleteMapping("/{forumId}")
    fun deleteForum(@PathVariable forumId: Long) {
        forumService.deleteForum(forumId)
    }
}