package com.example.noteapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.models.NoteModel

class NoteViewModel: ViewModel() {

    private var noteList = mutableStateListOf<NoteModel>()

    init {
        noteList.addAll(NoteDataSource().getNotes())
    }
    fun addNote(note: NoteModel){
        noteList.add(note)
    }

    fun deleteNote(note: NoteModel){
        noteList.remove(note)
    }

    fun getAllNotes(): List<NoteModel>{
        return noteList
    }

}