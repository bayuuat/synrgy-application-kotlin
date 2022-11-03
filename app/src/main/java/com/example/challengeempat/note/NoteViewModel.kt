package com.example.challengeempat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * ViewModel for SleepTrackerFragment.
 */
class NoteViewModel(
        val database: NoteDatabaseDao,
        application: Application) : AndroidViewModel(application) {


//    SETUP

    val allData = database.getAllNote()

    private var noteLiveData = MutableLiveData<Note?>()

    init {
        initializeTonight()
    }

//    GET

    private fun initializeTonight() {
        viewModelScope.launch {
            noteLiveData.value = getNoteFromDatabase()
        }
    }

    private suspend fun getNoteFromDatabase(): Note? {
        var note = database.getLastNote()
        return note
    }

//    INSERT

    fun addNote(note: Note) {
        viewModelScope.launch {
            database.insert(note)
            noteLiveData.value = getNoteFromDatabase()
        }
    }

//    UPDATE

    fun updateNote(note: Note) {
        viewModelScope.launch {
            database.update(note)
        }
    }

//    CLEAR ALL

    fun onClear() {
        viewModelScope.launch {
            database.clear()
            noteLiveData.value = null
        }
    }

    //    DELETE

    fun onDelete(note: Note) {
        viewModelScope.launch {
            database.delete(note)
            noteLiveData.value = getNoteFromDatabase()
        }
    }
}

