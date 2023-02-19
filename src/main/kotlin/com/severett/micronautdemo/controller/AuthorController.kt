package com.severett.micronautdemo.controller

import com.severett.micronautdemo.dto.AuthorDTO
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/authors")
class AuthorController {
    @Get(value = "/{id}", produces = [MediaType.APPLICATION_JSON])
    fun getAuthor(@PathVariable id: Int): AuthorDTO {
        return AuthorDTO("John", "Doe")
    }

    @Post
    fun saveAuthor(@Body authorDTO: AuthorDTO) {

    }

    @Delete("/{id}")
    fun deleteAuthor(@PathVariable id: Int) {

    }
}