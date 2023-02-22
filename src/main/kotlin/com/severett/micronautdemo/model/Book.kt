package com.severett.micronautdemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "book")
class Book(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var title: String,
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    var author: Author
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
