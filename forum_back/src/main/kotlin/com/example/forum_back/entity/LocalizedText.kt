package com.example.forum_back.entity

import com.example.forum_back.enums.Language
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class LocalizedText (
    language: Language
) : BaseTime() {

}