package com.example.forum_back.enums


enum class Language (
    private val code: String
){

    KO("en"),
    JP("jp"),
    EN("en");

    companion object {
        fun ofCode(code: String): Language {
            return entries.find { it.code == code } ?: EN
        }
    }
}