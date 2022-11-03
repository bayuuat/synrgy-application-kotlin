package com.example.challengeempat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Note.TABLE_NAME)
data class Note(
        @PrimaryKey(autoGenerate = true)
        var noteId: Long = 0L,

        @ColumnInfo(name = "note_title")
        var noteTitle: String? = "Default Title",

        @ColumnInfo(name = "note_content")
        var noteContent: String? = "Default Content",

        @ColumnInfo(name = "note_timestamp")
        var noteTimestamp: Long = System.currentTimeMillis()
){
        companion object{
                const val TABLE_NAME = "note_table"
        }
}