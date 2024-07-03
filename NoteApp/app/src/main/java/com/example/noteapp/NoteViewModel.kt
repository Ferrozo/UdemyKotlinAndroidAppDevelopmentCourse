package com.example.noteapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.models.NoteModel
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel  @Inject  constructor( private val noteRepository: NoteRepository): ViewModel() {

    private var _noteList = MutableStateFlow<List<NoteModel>>(emptyList())
     val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isEmpty()) {
                    _noteList.value = emptyList()
                } else {
                    _noteList.value = listOfNotes
                }
            }
        }
    }
     fun addNote(note: NoteModel) = viewModelScope.launch {
        noteRepository.addNote(note)
    }

     fun deleteNote(note: NoteModel) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

     fun updateNote(note: NoteModel) = viewModelScope.launch{
        noteRepository.updateNote(note)
    }

}