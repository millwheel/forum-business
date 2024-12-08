package com.example.forum_back.service

import com.example.forum_back.dto.ForumCreateRequestDto
import com.example.forum_back.dto.ForumUpdateRequestDto
import com.example.forum_back.entity.Forum
import com.example.forum_back.repository.ForumRepository
import com.example.forum_back.util.findByIdOrThrow
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
        return forumRepository.findByIdOrThrow(forumId)
    }

    fun getForumByAuthor(author: String) : List<Forum> {
        return forumRepository.findByAuthor(author)
    }

    @Transactional
    fun createForum(forumCreateRequestDto: ForumCreateRequestDto) {
        val newForum = Forum(forumCreateRequestDto.title, forumCreateRequestDto.description, forumCreateRequestDto.author)
        forumRepository.save(newForum)
    }

    @Transactional
    fun updateForum(forumId: Long, forumUpdateRequestDto: ForumUpdateRequestDto) {
        val forum = forumRepository.findByIdOrThrow(forumId)
        forum.updateForum(forumUpdateRequestDto)
    }

    @Transactional
    fun deleteForum(forumId: Long) {
        forumRepository.deleteById(forumId)
    }
}