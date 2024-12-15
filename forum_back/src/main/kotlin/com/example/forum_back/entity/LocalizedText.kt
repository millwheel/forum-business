package com.example.forum_back.entity

import com.example.forum_back.enums.Language
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class LocalizedText (
    @Enumerated(EnumType.STRING)
    open val language: Language
) : BaseTime()