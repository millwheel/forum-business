package com.example.forum_back.repository

import com.example.forum_back.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByForumId(forumId:Long): List<Comment>

}