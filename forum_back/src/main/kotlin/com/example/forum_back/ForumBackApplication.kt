package com.example.forum_back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ForumBackApplication

fun main(args: Array<String>) {
	runApplication<ForumBackApplication>(*args)
}
