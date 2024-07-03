package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.models.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes_tbl")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("SELECT * from notes_tbl where id = :id")
    suspend fun getNoteById(id: String): NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: NoteModel)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAllNotes()

    @Delete
   suspend fun delete(note: NoteModel)
}
