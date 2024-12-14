package com.example.forum_back.dto.user

import com.example.forum_back.entity.User

data class UserResponse (
    val id: Long,
    val email: String,
    val name: String,
) {
    companion object {
        fun of (user: User) : UserResponse {
            return UserResponse(
                id = user.id!!,
                email = user.email,
                name = user.name,
            )
        }
    }
}