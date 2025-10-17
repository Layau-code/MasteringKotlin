package com.layor

    fun main(args: Array<String>){
        val address ="1891@.com"
        val isValid = address.isValidEmail()
        println(isValid)
        val numbers = listOf(1,2,3,4,5)
        val sum = numbers.sum()
        println(sum)
    }
//扩展函数
fun String.isValidEmail(): Boolean {
    return Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matches(this)
}
//扩展List<Int>
fun List<Int>.sum(): Int {
    return this.fold(0) { sum, i -> sum + i }
}