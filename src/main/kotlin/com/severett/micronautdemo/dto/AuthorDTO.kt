package com.severett.micronautdemo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorDTO(
    @JsonProperty("firstName")
    val firstName: String,
    @JsonProperty("lastName")
    val lastName: String
)
