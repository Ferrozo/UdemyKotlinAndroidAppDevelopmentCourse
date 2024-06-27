package com.example.noteapp.models

import java.util.UUID

data class TodoModel(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val completed: Boolean
)
