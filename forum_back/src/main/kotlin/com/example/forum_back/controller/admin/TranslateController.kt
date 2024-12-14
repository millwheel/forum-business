package com.example.forum_back.controller.admin

import com.example.forum_back.sender.OpenaiApiSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/translate")
class TranslateController (
    private val openaiApiSender: OpenaiApiSender
) {

    @PostMapping
    fun translate() {
        openaiApiSender.sendRequestToOpenAI("st")
    }
}