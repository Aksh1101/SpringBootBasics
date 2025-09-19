package org.example.springbootbasics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootBasicsApplication

fun main(args: Array<String>) {
    runApplication<SpringBootBasicsApplication>(*args)
}
