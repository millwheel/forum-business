package com.example.forum_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "forum")
class Forum protected constructor() {

    @Id
    var id: Long? = null
    lateinit var title: String
    lateinit var description: String
    lateinit var author: String

    companion object {
        fun createNewForum(title: String, description: String, author: String): Forum {
            return Forum().apply {
                this.title = title
                this.description = description
                this.author = author
            }
        }
    }
}