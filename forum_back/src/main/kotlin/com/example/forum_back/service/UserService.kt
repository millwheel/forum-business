package com.example.forum_back.service

import com.example.forum_back.dto.user.UserCreateRequest
import com.example.forum_back.entity.User
import com.example.forum_back.repository.UserRepository
import com.example.forum_back.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository
) {

    fun getUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User {
        return userRepository.findByIdOrThrow(id)
    }

    @Transactional
    fun addUser(userCreateRequest: UserCreateRequest): User {
        if (userRepository.existsByEmail(userCreateRequest.email)) {
            throw RuntimeException("The email is already used")
        }
        val user = User(userCreateRequest.email, userCreateRequest.password, userCreateRequest.name)
        return userRepository.save(user)
    }

    @Transactional
    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

}