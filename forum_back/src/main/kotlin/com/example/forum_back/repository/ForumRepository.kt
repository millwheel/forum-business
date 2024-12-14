package com.example.forum_back.repository

import com.example.forum_back.entity.forum.Forum
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ForumRepository : JpaRepository<Forum, Long> {

    fun findAllByOrderByCreatedAtDesc(pageable: Pageable): List<Forum>

}