package com.layor

    fun main(args: Array<String>){
        val name1 = "layor"
        val greet ="hi"
        GreetUtil().greet(name1)
        GreetUtil().greet(name=name1,greet)

        3 times "hello"

    }
infix fun Int.times(str:String){
   val result = str.repeat( this)
    println(result)
}


    class GreetUtil{
        fun greet(name: String?,greet : String = "hello"){
            println("$greet!$name")
        }
    }