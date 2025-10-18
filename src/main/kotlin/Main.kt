package com.layor

    fun main(args: Array<String>){
        val dog = Dog()
        dog.makeSound()

        Notel.printNote()

        println(Animal.name)
        Animal.printName()

        //测试添加笔记
        val note = Note().apply {
            title = "hello"
            content = "world"
            createdAt = System.currentTimeMillis()
            id = 1
        }
        val memoryRepository = MemoryRepository()
        memoryRepository.insert(note)
        memoryRepository.insert(Note("hello","world",System.currentTimeMillis(),1))
    }
object Notel {
    val artial ="kotlin"
    val contens="kotlin is a great language"
    fun printNote(){
        println("$artial $contens")
    }
}