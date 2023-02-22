package com.severett.micronautdemo.repo

import com.severett.micronautdemo.model.Author
import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton
import javax.persistence.EntityManager

@Singleton
open class AuthorRepoImpl(
    private val entityManager: EntityManager
) : AuthorRepo {
    @ReadOnly
    override fun findById(id: Int): Author? {
        return entityManager.find(Author::class.java, id)
    }

    override fun save(author: Author) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }
}
