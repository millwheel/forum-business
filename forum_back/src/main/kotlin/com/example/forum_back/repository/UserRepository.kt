package com.example.forum_back.repository

import com.example.forum_back.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): User?

}