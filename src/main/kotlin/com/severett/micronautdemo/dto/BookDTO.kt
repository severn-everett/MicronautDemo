package com.severett.micronautdemo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BookDTO(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("authorId")
    val authorId: Int
)
