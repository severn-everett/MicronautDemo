package com.severett.micronautdemo.service

import com.severett.micronautdemo.dto.BookDTO
import com.severett.micronautdemo.model.Book
import com.severett.micronautdemo.repo.AuthorRepo
import com.severett.micronautdemo.repo.BookRepo
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.persistence.EntityNotFoundException

@Singleton
class BookService(private val bookRepo: BookRepo, private val authorRepo: AuthorRepo) {
    suspend fun getBook(id: Int): BookDTO {
        return withContext(Dispatchers.IO) {
            bookRepo.findById(id)?.let { BookDTO(title = it.title, authorId = it.author.id) }
                ?: throw EntityNotFoundException("No book found with id #$id")
        }
    }

    suspend fun saveBook(bookDTO: BookDTO) {
        withContext(Dispatchers.IO) {
            bookRepo.save(Book(title = bookDTO.title, author = authorRepo.getReference(bookDTO.authorId)))
        }
    }

    suspend fun deleteBook(id: Int) {
        withContext(Dispatchers.IO) {
            bookRepo.deleteById(id)
        }
    }
}
