package com.example.forum_back.service

import com.example.forum_back.dto.ForumRequestDto
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
            .orElseThrow{ RuntimeException("The forum ${forumId} does not exist") }
    }

    @Transactional
    fun addForum(forumRequestDto: ForumRequestDto) {
        val newForum = Forum.createNewForum(forumRequestDto.title, forumRequestDto.description, forumRequestDto.author)
        forumRepository.save(newForum)
    }

    @Transactional
    fun deleteForum(forumId: Long) {
        forumRepository.deleteById(forumId)
    }
}