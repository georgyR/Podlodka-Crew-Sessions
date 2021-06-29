package com.georgy_r.podlodkaandroidcrew.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgy_r.podlodkaandroidcrew.data.mockSessions

class SessionListViewModel : ViewModel() {

    private val _sessionItems: MutableLiveData<List<SessionUiItem>> = MutableLiveData(getItems())

    val sessionItems: LiveData<List<SessionUiItem>> = _sessionItems


    private fun getItems(): List<SessionUiItem> = SessionUiItemsConverter().convert(mockSessions)

}
