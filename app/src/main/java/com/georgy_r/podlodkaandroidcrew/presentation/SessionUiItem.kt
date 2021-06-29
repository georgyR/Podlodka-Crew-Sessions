package com.georgy_r.podlodkaandroidcrew.presentation

sealed class SessionUiItem {

    data class Session(
        val id: String,
        val speaker: String,
        val timeInterval: String,
        val description: String,
        val imageUrl: String
    ): SessionUiItem()

    data class Date(val title: String): SessionUiItem()

}