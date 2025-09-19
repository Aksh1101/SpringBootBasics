package org.example.springbootbasics

import org.springframework.core.io.FileSystemResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class HelloWorldController {
    @GetMapping()
    fun hello() = "Hello Aksh"


}