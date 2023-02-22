package com.severett.micronautdemo.service

import com.severett.micronautdemo.dto.AuthorDTO
import com.severett.micronautdemo.model.Author
import com.severett.micronautdemo.repo.AuthorRepo
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.persistence.EntityNotFoundException

@Singleton
class AuthorService(private val authorRepo: AuthorRepo) {
    suspend fun getAuthor(id: Int): AuthorDTO {
        return withContext(Dispatchers.IO) {
            authorRepo.findById(id)?.let { AuthorDTO(firstName = it.firstName, lastName = it.lastName) }
                ?: throw EntityNotFoundException("No author found with id #$id")
        }
    }

    suspend fun saveAuthor(authorDTO: AuthorDTO) {
        withContext(Dispatchers.IO) {
            authorRepo.save(Author(firstName = authorDTO.firstName, lastName = authorDTO.lastName))
        }
    }

    suspend fun deleteAuthor(id: Int) {
        withContext(Dispatchers.IO) {
            authorRepo.deleteById(id)
        }
    }
}
