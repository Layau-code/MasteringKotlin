package com.layor

import kotlinx.coroutines.delay
import java.util.concurrent.Delayed

open class BaseNoteRepository {
    protected open val notes = mutableListOf<Note>()

    open suspend fun getAll(): NoteResult {
        return try {
            delay(1000) // 模拟网络延迟
            NoteResult.Success(notes.toList())
        } catch (e: Exception) {
            NoteResult.Error(e.message ?: "未知错误")
        }
    }
    open fun insert(note: Note) {
        notes.add(note)
    }

    open fun delete(id: Int) {
        notes.removeIf { it.id == id }
    }
    fun displayNotes(result: NoteResult) {
        when (result) {
            NoteResult.Loading -> println("⏳ 加载中...")
            is NoteResult.Success -> println("✅ 成功：${result.data}")
            is NoteResult.Error -> println("❌ 错误：${result.message}")
            is NoteResult.Empty -> println("⚠️ 空结果")
        }
    }
}
