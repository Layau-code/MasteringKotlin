package com.layor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main(args: Array<String>){
    val repo = MemoryRepository()
    repo.insert(Note( "hello", "world", System.currentTimeMillis(), 1))

    val result = repo.getAll()
    repo.displayNotes(result)
}
