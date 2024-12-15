package com.example.forum_back.entity.forum

import com.example.forum_back.entity.LocalizedText
import com.example.forum_back.enums.Language
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ForumLocalizedText constructor(
    var title: String,
    var description: String,
    val entityId: Long,
    override val language: Language,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : LocalizedText(language) {


    fun updateTitle(newTitle: String) {
        this.title = newTitle
    }

    fun updateDescription(newDescription: String) {
        this.description = newDescription
    }

}