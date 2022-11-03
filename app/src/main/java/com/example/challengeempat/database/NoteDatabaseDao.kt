package com.example.challengeempat

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDatabaseDao {

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from note_table WHERE noteId = :key")
    suspend fun get(key: Long): Note?

    @Query("DELETE FROM note_table")
    suspend fun clear()

    @Query("SELECT * FROM note_table ORDER BY noteId DESC LIMIT 1")
    suspend fun getLastNote(): Note?

    @Query("SELECT * FROM note_table ORDER BY noteId DESC")
    fun getAllNote(): LiveData<List<Note>>
}