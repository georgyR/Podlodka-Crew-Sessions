package com.georgy_r.podlodkaandroidcrew.feature.home.model

data class HomeUiState(
    val favoriteSessions: List<SessionUiItem.Session>,
    val sessionItems: List<SessionUiItem>
) {
    companion object {
        val EMPTY = HomeUiState(emptyList(), emptyList())
    }
}