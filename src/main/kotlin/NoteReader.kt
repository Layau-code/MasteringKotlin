package com.layor

import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

class NoteReader {
    private val file = File("notes.json")
    private val json = Json { prettyPrint = true }

    // 从文件加载所有笔记
    fun loadNotes(): Result<List<Note>> = runCatching{
            if (file.exists()) {
                val content = file.readText()
                json.decodeFromString<List<Note>>(content)
            } else {
                emptyList() // 文件不存在，返回空列表
            }
    }

    // 保存笔记列表到文件
    fun saveNotes(notes: List<Note>): Result<Unit> = runCatching{
            val content = json.encodeToString(ListSerializer(Note.serializer()), notes)
            file.writeText(content)
    }
}

