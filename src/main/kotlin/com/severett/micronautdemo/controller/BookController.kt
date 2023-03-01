package com.severett.micronautdemo.controller

import com.severett.micronautdemo.dto.BookDTO
import com.severett.micronautdemo.service.BookService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/books")
class BookController(private val bookService: BookService) {
    @Get(value = "/{id}", produces = [MediaType.APPLICATION_JSON])
    suspend fun getBook(@PathVariable id: Int): BookDTO {
        return bookService.getBook(id)
    }

    @Post
    suspend fun getBook(@Body bookDTO: BookDTO) {
        bookService.saveBook(bookDTO)
    }

    @Delete("/{id}")
    suspend fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }
}
