package com.layor

fun main(args: Array<String>){
 //Elvis操作符
 val name :String? = null
 val length = name?.length ?: -1
 println(length)
 //非空断言
 //val len= name!!.length
//空处理函数
 printNameAndage(name, 18)

}
private  fun printNameAndage(name: String?, age: Int){
    println("名字是${name?:"匿名"}，年龄是${age}")
}