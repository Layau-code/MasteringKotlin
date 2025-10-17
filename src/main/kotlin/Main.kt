package com.layor

    fun main(args: Array<String>){
        //apply
        val note = Note().apply {
            title = "学习Kotlin"
            content = "今天学了apply"
            createdAt = System.currentTimeMillis()
        }
        println(note)
        //also
        val list = mutableListOf(1,2,3)
        list.also { println("添加前：$list") }
            .add(4)
            .also { println("添加后：$list") }
        //let
        val name: String? = "a"
        name?.let {
            println("名字是: $it")  // it 指代 name
            println("长度: ${it.length}")
        }
        //run
        val result = note.run {
            "$title - ${content.take(10)}..."
        }
        println(result) // 学习Kotlin - 今天学了app...

    }
