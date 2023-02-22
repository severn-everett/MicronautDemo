package com.severett.micronautdemo.repo

import com.severett.micronautdemo.model.Author
import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Suppress("MnInjectionPoints")
@Singleton
open class AuthorRepoImpl(
    private val entityManager: EntityManager
) : AuthorRepo {
    @ReadOnly
    override fun findById(id: Int): Author? {
        return entityManager.find(Author::class.java, id)
    }

    @Transactional
    override fun save(author: Author) {
        entityManager.persist(author)
    }

    @Transactional
    override fun deleteById(id: Int) {
        findById(id)?.let(entityManager::remove)
    }
}
