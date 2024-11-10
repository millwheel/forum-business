package com.example.forum_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "forum")
class Forum(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var description: String,
    var author: String
) {
    companion object {
        fun createNewForum(title: String, description: String, author: String): Forum {
            return Forum(
                title = title,
                description = description,
                author = author
            )
        }
    }

}