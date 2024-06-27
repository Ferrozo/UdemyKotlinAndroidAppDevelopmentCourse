package com.example.noteapp.data

import com.example.noteapp.models.NoteModel
import com.example.noteapp.ui.theme.DarkColor

class NoteDataSource {
    fun getNotes(): List<NoteModel>{
        return listOf(
            NoteModel(
                title = "First note",
                description = "This is an note example",
                color = DarkColor,
                category = "Work",
                locked = false,
            )
        )
    }
}