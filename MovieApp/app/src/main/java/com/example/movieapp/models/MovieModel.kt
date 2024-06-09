package com.example.movieapp.models

data class MovieModel(
    val  title: String,
    val genres: List<String>,
    val director: String,
    val img: String,
    val rating: Double,
    val description: String,
    val actors: List<String>,
)
