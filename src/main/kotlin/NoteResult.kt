package com.layor

sealed class NoteResult {
    object Loading : NoteResult()
    data class Success(val data: List<Note>) : NoteResult()
    data class Error(val message: String) : NoteResult()
    data class Empty(val message: String) : NoteResult()
}