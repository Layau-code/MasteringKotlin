
package com.layor

import kotlinx.serialization.Serializable


@Serializable
data class Note(var title: String = "", var content: String = "", var createdAt: Long = 0, var id : Int =0)