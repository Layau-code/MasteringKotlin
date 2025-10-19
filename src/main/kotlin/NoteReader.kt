package com.layor

import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

class NoteReader {
    private val file = File("notes.json")
    private val json = Json { prettyPrint = true }

    // 从文件加载所有笔记
    fun loadNotes(): List<Note> {
        return try {
            if (file.exists()) {
                val content = file.readText()
                json.decodeFromString<List<Note>>(content)
            } else {
                emptyList() // 文件不存在，返回空列表
            }
        } catch (e: Exception) {
            println("读取文件失败: ${e.message}")
            emptyList()
        }
    }

    // 保存笔记列表到文件
    fun saveNotes(notes: List<Note>) {
        return try {
            val content = json.encodeToString(ListSerializer(Note.serializer()), notes)
            file.writeText(content)
            println("✅ 笔记已保存到 ${file.absolutePath}")
        } catch (e: Exception) {
            println("❌ 保存失败: ${e.message}")
        }
    }
}

