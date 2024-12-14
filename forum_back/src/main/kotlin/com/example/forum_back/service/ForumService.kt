package com.example.forum_back.service

import com.example.forum_back.dto.forum.ForumCreateRequest
import com.example.forum_back.dto.forum.ForumResponse
import com.example.forum_back.dto.forum.ForumSummaryResponse
import com.example.forum_back.dto.forum.ForumUpdateRequest
import com.example.forum_back.entity.forum.Forum
import com.example.forum_back.repository.ForumRepository
import com.example.forum_back.repository.UserRepository
import com.example.forum_back.util.findByIdOrThrow
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ForumService (
    private val forumRepository : ForumRepository,
    private val userRepository : UserRepository
) {

    fun getAllForums(pageNumber: Int) : List<ForumSummaryResponse> {
        val pageable: Pageable = PageRequest.of(pageNumber, 10)
        val forums = forumRepository.findAllByOrderByCreatedAtDesc(pageable)
        return forums.map { forum ->
            val user = userRepository.findByIdOrThrow(forum.authorId)
            ForumSummaryResponse.of(forum, user)
        }
    }

    fun getForumById(forumId : Long) : ForumResponse {
        val forum = forumRepository.findByIdOrThrow(forumId)
        val user = userRepository.findByIdOrThrow(forum.authorId)
        return ForumResponse.of(forum, user)
    }

    @Transactional
    fun createForum(forumCreateRequest: ForumCreateRequest) : Forum {
        if(!userRepository.existsById(forumCreateRequest.authorId)){
            throw RuntimeException("User Not Found")
        }
        val newForum = Forum(forumCreateRequest.title, forumCreateRequest.description, forumCreateRequest.authorId)
        return forumRepository.save(newForum)
    }

    @Transactional
    fun updateForum(forumId: Long, forumUpdateRequest: ForumUpdateRequest) : Forum {
        val forum = forumRepository.findByIdOrThrow(forumId)
        forum.updateForum(forumUpdateRequest)
        return forumRepository.save(forum)
    }

    @Transactional
    fun deleteForum(forumId: Long) {
        forumRepository.deleteById(forumId)
    }
}