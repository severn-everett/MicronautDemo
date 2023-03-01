package com.severett.micronautdemo.controller

import com.severett.micronautdemo.dto.AuthorDTO
import com.severett.micronautdemo.service.AuthorService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/authors")
class AuthorController(private val authorService: AuthorService) {
    @Get(value = "/{id}", produces = [MediaType.APPLICATION_JSON])
    suspend fun getAuthor(@PathVariable id: Int): AuthorDTO {
        return authorService.getAuthor(id)
    }

    @Post
    suspend fun saveAuthor(@Body authorDTO: AuthorDTO) {
        authorService.saveAuthor(authorDTO)
    }

    @Delete("/{id}")
    suspend fun deleteAuthor(@PathVariable id: Int) {
        authorService.deleteAuthor(id)
    }
}