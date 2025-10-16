package com.layor

data class Article (
    val title: String,
    val content: String,
    val author: User,
    val date: String,
    val id: Int,
    val tags: List<String>
)