package com.example.forum_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User (
    var email: String,
    var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if (email.isBlank()) {
            throw IllegalArgumentException("email cannot be blank")
        }
        if (name.isBlank()) {
            throw IllegalArgumentException("name cannot be blank")
        }
    }

}