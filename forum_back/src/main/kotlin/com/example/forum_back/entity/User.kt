package com.example.forum_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
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
        if (this.password.isBlank()) {
            throw IllegalArgumentException("password cannot be blank")
        }
    }

}