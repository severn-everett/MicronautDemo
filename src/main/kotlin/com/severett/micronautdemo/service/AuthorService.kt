package com.severett.micronautdemo.service

import com.severett.micronautdemo.dto.AuthorDTO
import io.micronaut.context.annotation.Bean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Bean
class AuthorService {
    suspend fun getAuthor(id: Int): AuthorDTO {
        return withContext(Dispatchers.IO) {
            AuthorDTO("John", "Doe")
        }
    }

    suspend fun saveAuthor(authorDTO: AuthorDTO) {
        withContext(Dispatchers.IO) {

        }
    }

    suspend fun deleteAuthor(id: Int) {
        withContext(Dispatchers.IO) {

        }
    }
}
