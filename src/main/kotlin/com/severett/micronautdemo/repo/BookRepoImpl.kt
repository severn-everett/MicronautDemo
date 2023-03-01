package com.severett.micronautdemo.repo

import com.severett.micronautdemo.model.Book
import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Suppress("MnInjectionPoints")
@Singleton
open class BookRepoImpl(private val entityManager: EntityManager) : BookRepo {
    @ReadOnly
    override fun findById(id: Int): Book? {
        return entityManager.find(Book::class.java, id)
    }

    @Transactional
    override fun save(book: Book) {
        entityManager.persist(book)
    }

    @Transactional
    override fun deleteById(id: Int) {
        findById(id)?.let(entityManager::remove)
    }
}
