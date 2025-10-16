package com.layor

fun main(args: Array<String>){
    val name : String? = "Alice"
    var age = 18
    printNameAndage(name, age)
    val length = name?.length
    println(length)
    println(leagle(name))

}

private fun printNameAndage(name: String?, age: Int) {
    println("${name}今年${age + 1}岁了")
}
private fun leagle(name: String?) :Boolean{
    return name!=null&&name.length>3
}
