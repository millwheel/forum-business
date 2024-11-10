package com.example.forum_back.repository

import com.example.forum_back.entity.Forum
import org.springframework.data.jpa.repository.JpaRepository

interface ForumRepository : JpaRepository<Forum, Long> {
}