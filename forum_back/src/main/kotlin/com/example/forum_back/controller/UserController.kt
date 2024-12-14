package com.example.forum_back.controller

import com.example.forum_back.dto.ResponseResult
import com.example.forum_back.dto.user.UserCreateRequest
import com.example.forum_back.dto.user.UserResponse
import com.example.forum_back.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/public/user")
class UserController (
    private val userService: UserService
) {

    @GetMapping
    fun findAll(): ResponseResult<List<UserResponse>> {
        val users = userService.getUsers()
        val userResponses = users.map { UserResponse.of(it) }
        return ResponseResult(userResponses)
    }

    @PostMapping
    fun create(@RequestBody userCreateRequest: UserCreateRequest) {
        userService.addUser(userCreateRequest)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        userService.deleteUser(id)
    }

}