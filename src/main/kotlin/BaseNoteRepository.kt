package com.layor

open class BaseNoteRepository {
    protected open val notes = mutableListOf<Note>()

    open fun getAll(): List<Note> = notes

    open fun insert(note: Note) {
        notes.add(note)
    }

    open fun delete(id: Int) {
        notes.removeIf { it.id == id }
    }
}
