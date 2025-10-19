package com.layor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

 fun main(args: Array<String>){
     val note = Note().apply {
         title = "hello"
         content = "world"
         createdAt = System.currentTimeMillis()
         id = 4
     }
     val memoryRepository = MemoryRepository()
      memoryRepository.insert(note)
}
