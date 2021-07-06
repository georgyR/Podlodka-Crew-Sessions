package com.georgy_r.podlodkaandroidcrew.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgy_r.podlodkaandroidcrew.common.data.mockSessions
import com.georgy_r.podlodkaandroidcrew.feature.home.model.HomeUiState
import com.georgy_r.podlodkaandroidcrew.feature.home.model.SessionUiItem

class HomeViewModel : ViewModel() {

    private val _state: MutableLiveData<HomeUiState> = MutableLiveData(getInitialState())

    val state: LiveData<HomeUiState> = _state

    fun onFavoriteClicked(id: String) {
        val state = state.getValueOrDef()

        val session = state.sessionItems
            .filterIsInstance<SessionUiItem.Session>()
            .find { it.id == id }
            ?: return

        val favoriteSessions = state.favoriteSessions.toMutableList()

        val newFavoriteState = !session.isFavorite
        val newSession = session.copy(isFavorite = newFavoriteState)
        val newState = state.copy(
            favoriteSessions = if (newFavoriteState) {
                favoriteSessions.plus(newSession)
            } else {
                favoriteSessions.filter { it.id != session.id }
            },
            sessionItems = state.sessionItems.map { item ->
                if (item is SessionUiItem.Session && item.id == id) {
                    newSession
                } else {
                    item
                }
            }
        )

        _state.value = newState
    }

    private fun getInitialState(): HomeUiState {
        return HomeUiState(
            favoriteSessions = emptyList(),
            sessionItems = SessionUiItemsConverter().convertToSessionItems(mockSessions)
        )
    }

    private fun LiveData<HomeUiState>.getValueOrDef() = value ?: getInitialState()

}
