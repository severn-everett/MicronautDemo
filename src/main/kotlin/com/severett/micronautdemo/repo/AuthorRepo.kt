package com.severett.micronautdemo.repo

import com.severett.micronautdemo.model.Author

interface AuthorRepo {
    fun findById(id: Int): Author?
    fun save(author: Author)
    fun deleteById(id: Int)
}
