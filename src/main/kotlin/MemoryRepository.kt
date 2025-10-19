package com.layor

class MemoryRepository : BaseNoteRepository{
    private val notes = mutableListOf<Note>()
    private val noteReader = NoteReader()
    init {
        val savedNotes = noteReader.loadNotes().onSuccess {
            note -> notes.addAll(note)
            println("已加载笔记：${note.size}")
        }.onFailure {
            e -> println("加载笔记失败：${e.message}")
        }

    }
    override fun getAll(): List<Note>{
        return notes
    }

    override fun insert (note: Note) {
        //如果不存在才插入
        if (notes.none { it.id == note.id }) {
            notes.add(note)
            val result = noteReader.saveNotes(notes)
            result.onSuccess { print("保存成功: ${note}") }
                .onFailure { print("保存失败：${it.message}") }
        }else{
            print("笔记已存在：note id=${note.id}")
        }

    }

    override fun delete(id: Int) {
        notes.removeIf { it.id == id }.also { print("删除成功：${id}") }
       val result = noteReader.saveNotes(notes)
        result.onSuccess { print("保存成功") }
            .onFailure { print("保存失败：${it.message}") }
    }

    override fun update(note: Note) {
        val index = notes.indexOfFirst { it.id == note.id }
        if (index != -1) {
            notes[index] = note
            val result = noteReader.saveNotes(notes)
            result.onSuccess { print("保存成功") }
                .onFailure { print("保存失败：${it.message}") }
        }
    }

    override fun findById(id: Int): Note? {
        return notes.find { it.id == id }
    }
}
