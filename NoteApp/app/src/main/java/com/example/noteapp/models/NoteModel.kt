package com.example.noteapp.models

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class NoteModel(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val description: String,
    @ColumnInfo
    val category: String,
    @ColumnInfo
    val locked: Boolean,
    @ColumnInfo
    val pin: Int? = null,
    @ColumnInfo
    val color: String,
    @ColumnInfo
    val createdAt: Date = Date.from(Instant.now()),
){
    constructor(): this(title = "", description = "", category = "", locked = false, color ="")
}
