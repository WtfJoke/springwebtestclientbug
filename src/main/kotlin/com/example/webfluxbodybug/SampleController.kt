package com.example.webfluxbodybug

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class SampleController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    fun hello(): StringContainer {
        return StringContainer("hi")
    }

    @GetMapping("/exception")
    @ResponseStatus(HttpStatus.OK)
    fun exception(): StringContainer {
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "my custom error msg")
    }
}