package com.solomaticydl.astronomy.state

sealed class UiState<out T : Any> {
    data class Success<out T : Any>(val data: T) : UiState<T>()
    data class Error(val exception: Throwable) : UiState<Nothing>()
    object InProgress : UiState<Nothing>()

    val extractData: T?
        get() = when (this) {
            is Success -> data
            is Error -> null
            is InProgress -> null
        }
}