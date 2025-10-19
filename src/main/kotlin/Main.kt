package com.layor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

suspend fun main(args: Array<String>){
    val json = Json {
        prettyPrint = true // 格式化输出，方便查看
    }

    val note = Note("hello","kotlin",System.currentTimeMillis(),1)

// 对象 → JSON 字符串（序列化）
    val jsonString = json.encodeToString(Note.serializer(), note)
    println(jsonString)
// 输出：
// {
//   "id": 1,
//   "title": "标题",
//   "content": "内容"
// }

// JSON 字符串 → 对象（反序列化）
    val decodedNote = json.decodeFromString<Note>(jsonString)
    println(decodedNote) // Note(id=1, title=标题, content=内容)


//    写入笔记
    val noteReader = NoteReader()
//    val note2= Note("hello","Java",System.currentTimeMillis(),2)
//    noteReader.saveNotes(listOf(note,note2))

    //读取笔记
    val notes = noteReader.loadNotes()
    for (note in notes) {
        println(note)
    }

    val repo=MemoryRepository()
    //测试插入
    val note3 = Note("hello","layor",System.currentTimeMillis(),3)
    repo.insert(note3)
    //测试查询
    val note4 = repo.findById(3)
    println(note4)
    //测试更新
    note4?.let {
        it.title = "layor"
        repo.update(it)
        println(repo.findById(3))
    }
    //测试删除
    repo.delete(3)
    println(repo.findById(3))
    //测试所有
    for (note in repo.getAll()) {
        println(note)
    }

}
