package com.georgy_r.podlodkaandroidcrew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.georgy_r.podlodkaandroidcrew.base_ui.theme.PodlodkaAndroidCrewTheme
import com.georgy_r.podlodkaandroidcrew.presentation.SessionListViewModel
import com.georgy_r.podlodkaandroidcrew.presentation.ui.SessionList

class MainActivity : ComponentActivity() {

    private val sessionListViewModel: SessionListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaAndroidCrewTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SessionList(sessionListViewModel.sessionItems.value ?: emptyList())
                }
            }
        }
    }
}