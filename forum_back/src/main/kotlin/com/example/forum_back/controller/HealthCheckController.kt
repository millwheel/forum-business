package com.example.forum_back.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
class HealthCheckController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun healthCheck() = "server is running";

}