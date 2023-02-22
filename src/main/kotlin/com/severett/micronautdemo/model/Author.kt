package com.severett.micronautdemo.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "author")
class Author(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    @field:Column(name = "first_name")
    var firstName: String,
    @field:Column(name = "last_name")
    var lastName: String,
    @OneToMany(mappedBy = "author", cascade = [CascadeType.ALL])
    var books: List<Book> = emptyList()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Author) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}