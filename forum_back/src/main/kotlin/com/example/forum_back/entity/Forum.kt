package com.example.forum_back.entity

import jakarta.persistence.*
import jakarta.persistence.GenerationType.*

@Entity
@Table(name = "forum")
class Forum (
    var title: String,
    var description: String,
    var author: String,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    init {
        if (title.isBlank()) {
            throw IllegalArgumentException("title cannot be blank")
        }
    }

}