package com.georgy_r.podlodkaandroidcrew.presentation.model

data class HomeUiState(
    val favoriteSessions: List<SessionUiItem.Session>,
    val sessionItems: List<SessionUiItem>
) {
    companion object {
        val EMPTY = HomeUiState(emptyList(), emptyList())
    }
}