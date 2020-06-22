package com.example.webfluxbodybug

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerTest(@Autowired private val webTestClient: WebTestClient) {

    @Test
    fun exception() {
        webTestClient.get().uri("/exception")
                .exchange()
                .expectStatus().isBadRequest
                .expectBody()
                .jsonPath("$.message").isEqualTo("my custom error msg")
    }

    @Test
    fun `hello`() {
        webTestClient.get().uri("/hello")
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .jsonPath("$.atext").isEqualTo("hi")
    }


}