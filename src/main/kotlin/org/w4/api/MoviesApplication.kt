package org.w4.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoviesApplication

fun main(args: Array<String>) {
	runApplication<MoviesApplication>(*args)
}
