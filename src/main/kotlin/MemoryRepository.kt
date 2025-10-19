package com.layor

class MemoryRepository : BaseNoteRepository{
    private val notes = mutableListOf<Note>()
    private val noteReader = NoteReader()
    init {
        val savedNotes = noteReader.loadNotes()
        notes.addAll(savedNotes)
    }
    override fun getAll(): List<Note> {
        return notes
    }

    override fun insert (note: Note) {
        notes.add(note)
        noteReader.saveNotes(notes)
    }

    override fun delete(id: Int) {
        notes.removeIf { it.id == id }.also { print("删除成功：${id}") }
        noteReader.saveNotes(notes)
    }

    override fun update(note: Note) {
        val index = notes.indexOfFirst { it.id == note.id }
        if (index != -1) {
            notes[index] = note
            noteReader.saveNotes(notes)
        }
    }

    override fun findById(id: Int): Note? {
        return notes.find { it.id == id }
    }
}
