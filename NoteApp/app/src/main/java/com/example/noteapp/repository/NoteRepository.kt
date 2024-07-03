package com.example.noteapp.repository

import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: NoteModel)  = noteDatabaseDao.insertNote(note)
    suspend fun updateNote(note: NoteModel) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note: NoteModel) = noteDatabaseDao.delete(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNotes()
    suspend fun getAllNotes(): Flow<List<NoteModel>> = noteDatabaseDao.getAllNotes()
        .flowOn(Dispatchers.IO).conflate()
}