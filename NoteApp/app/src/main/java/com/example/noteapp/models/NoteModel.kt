package com.example.noteapp.models

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime
import java.util.UUID

data class NoteModel(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val category: String,
    val locked: Boolean,
    val pin: Int? = null,
    val color: Color,
    val todo: List<TodoModel>?= null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val completedAt: Long? = null
)
