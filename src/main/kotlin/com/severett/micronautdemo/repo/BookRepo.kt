package com.severett.micronautdemo.repo

import com.severett.micronautdemo.model.Book

interface BookRepo {
    fun findById(id: Int): Book?
    fun save(book: Book)
    fun deleteById(id: Int)
}