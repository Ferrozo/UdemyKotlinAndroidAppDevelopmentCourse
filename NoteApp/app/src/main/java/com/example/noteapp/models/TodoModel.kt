package com.example.noteapp.models

import androidx.room.TypeConverters
import com.example.noteapp.util.UUIDConverter
import java.util.UUID

@TypeConverters(UUIDConverter::class)
data class TodoModel(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val completed: Boolean
)
