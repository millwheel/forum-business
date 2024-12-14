package com.example.forum_back.dto.user

data class UserCreateRequest (
    val email: String,
    val password: String,
    val name: String,
)