package com.layor

class MemoryRepository:BaseNoteRepository() {
    override  fun insert (note: Note) {
        if(notes.none{it.id==note.id}){
            notes.add(note)
            println("笔记添加成功: $note")
        }else{
            println("笔记已存在: $note")
        }
    }
}