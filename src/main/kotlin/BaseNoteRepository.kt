package com.layor

import kotlinx.coroutines.delay
import java.util.concurrent.Delayed

interface BaseNoteRepository {
    fun getAll(): List<Note>
    fun insert(note: Note)
    fun delete(id: Int)
    fun update(note: Note)
    fun findById(id: Int): Note?
}
