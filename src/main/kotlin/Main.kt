package com.layor

    fun main(args: Array<String>){
      val list = listOf("liabi","layor","layor","kl")
      val list2 = mutableListOf("liabi","layor","layor","kl")
       val isL = list.filter{it.startsWith("l")}
        println(isL)
        list2.add("zhangdan")
        list2.remove("layor")
       val list3 = list2.map{it.uppercase()}
        //链式调用
        val list4 = list2.filter{it.startsWith("l")}.map{it.uppercase()}
        println(list4)
        println(list3+list2)

    }
