package com.example.forum_back.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

class User (
    var email : String,
    var password: String,
    var name: String,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
){

    init {
        if (this.email.isBlank()) {
            throw IllegalArgumentException("email cannot be blank")
        }
        if (isValidEmail(this.email)){
            throw IllegalArgumentException("Invalid email format")
        }
        if (this.password.isBlank()) {
            throw IllegalArgumentException("password cannot be blank")
        }
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return emailRegex.matches(email)
    }

}