package com.georgy_r.podlodkaandroidcrew.feature.home.model

sealed class SessionUiItem {

    data class Session(
        val id: String,
        val speaker: String,
        val date: String,
        val timeInterval: String,
        val description: String,
        val imageUrl: String,
        val isFavorite: Boolean = false
    ) : SessionUiItem()

    data class Date(val title: String) : SessionUiItem()

}