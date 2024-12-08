package com.example.forum_back.util

import org.springframework.data.repository.CrudRepository

fun fail(): Nothing = throw IllegalArgumentException()

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T {
    return findByIdOrThrow(id) ?: fail()
}