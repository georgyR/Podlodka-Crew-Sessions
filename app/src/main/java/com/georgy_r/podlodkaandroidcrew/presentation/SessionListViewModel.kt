package com.georgy_r.podlodkaandroidcrew.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgy_r.podlodkaandroidcrew.data.Session
import com.georgy_r.podlodkaandroidcrew.data.mockSessions

class SessionListViewModel : ViewModel() {

    private val _session: MutableLiveData<List<Session>> = MutableLiveData(mockSessions)

    val session: LiveData<List<Session>> = _session

}
