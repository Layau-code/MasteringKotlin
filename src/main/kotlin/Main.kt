package com.layor

fun main(args: Array<String>){
 //使用user类
   val user=User("layor", 27)
    val user1=User("layor", 27)

    println(user==user1)
    println(user===user1)
    println(user.hashCode())
    println(user1.hashCode())
    println(user.toString())
    println(user1.toString())
    println(user)
//使用copy方法
 val user2=user.copy("layor")
 println(user2)
 println(user2.component1())
 println(user2.component2())
 println(user1==user2)
 //解构赋值
 val (name, age)=user
 println("name:$name, age:$age")

 //使用数据类嵌套
 val article=Article(
   title="Kotlin",
  author=User("layor", 27)
 , content="Kotlin is a modern programming language"
 , date="2020-01-01"
 , id=1
 , tags= listOf("Kotlin", "Programming"))
 println(article)

}
