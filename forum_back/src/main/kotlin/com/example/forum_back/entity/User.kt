package com.example.forum_back.entity

import com.example.forum_back.entity.constant.UserRole
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User constructor (
    var email: String,
    var name: String,
    var userRole: UserRole,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if (email.isBlank()) {
            throw IllegalArgumentException("email cannot be blank")
        }
        validateName(name);
    }

    fun changeName(newName: String) {
        validateName(newName);
        this.name = newName
    }

    final fun validateName(newName: String) {
        if (newName.isBlank()) {
            throw IllegalArgumentException("name cannot be blank")
        }
    }

}