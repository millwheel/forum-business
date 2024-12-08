package com.example.forum_back.service

import com.example.forum_back.dto.ForumCreateRequestDto
import com.example.forum_back.dto.ForumUpdateRequestDto
import com.example.forum_back.entity.Forum
import com.example.forum_back.repository.ForumRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ForumService (
    private val forumRepository : ForumRepository
) {

    fun getAllForums() : List<Forum> {
        return forumRepository.findAll()
    }

    fun getForumById(forumId : Long) : Forum {
        return forumRepository.findById(forumId)
            .orElseThrow{ RuntimeException("The forum $forumId does not exist") }
    }

    @Transactional
    fun createForum(forumCreateRequestDto: ForumCreateRequestDto) {
        val newForum = Forum(forumCreateRequestDto.title, forumCreateRequestDto.description, forumCreateRequestDto.author)
        forumRepository.save(newForum)
    }

    @Transactional
    fun updateForum(forumId: Long, forumUpdateRequestDto: ForumUpdateRequestDto) {
        val forum = forumRepository.findById(forumId)
            .orElseThrow { RuntimeException("The forum $forumId does not exist") }
        forum.updateForum(forumUpdateRequestDto)
    }

    @Transactional
    fun deleteForum(forumId: Long) {
        forumRepository.deleteById(forumId)
    }
}