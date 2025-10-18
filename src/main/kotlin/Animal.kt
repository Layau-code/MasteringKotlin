package com.layor

open class Animal {
    companion object {
        const val name = "layor"
        fun printName(){
            println(name)
        }
    }
   open fun makeSound(){
        println("The animal makes a sound")
    }
}