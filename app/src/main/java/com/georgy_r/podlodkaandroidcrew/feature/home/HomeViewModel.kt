package com.georgy_r.podlodkaandroidcrew.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgy_r.podlodkaandroidcrew.common.data.mockSessions
import com.georgy_r.podlodkaandroidcrew.feature.home.model.HomeUiState

class HomeViewModel : ViewModel() {

    private val _state: MutableLiveData<HomeUiState> = MutableLiveData(getMockState())

    val state: LiveData<HomeUiState> = _state


    private fun getMockState(): HomeUiState {
        return HomeUiState(
            favoriteSessions = SessionUiItemsConverter().convertToSimpleItems(mockSessions),
            sessionItems = SessionUiItemsConverter().convertToSessionItems(mockSessions)
        )
    }

}
