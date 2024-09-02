package com.example.capstoneapp.models

data class BookModel(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)