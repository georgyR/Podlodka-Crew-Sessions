package com.georgy_r.podlodkaandroidcrew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.georgy_r.podlodkaandroidcrew.common.base_ui.theme.PodlodkaAndroidCrewTheme
import com.georgy_r.podlodkaandroidcrew.feature.home.HomeViewModel
import com.georgy_r.podlodkaandroidcrew.feature.home.model.HomeUiState
import com.georgy_r.podlodkaandroidcrew.feature.home.ui.FavoriteList
import com.georgy_r.podlodkaandroidcrew.feature.home.ui.SectionHeader
import com.georgy_r.podlodkaandroidcrew.feature.home.ui.SessionItem

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val state = homeViewModel.state.value ?: HomeUiState.EMPTY
        setContent {
            PodlodkaAndroidCrewTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        item { SectionHeader("Избранное") }
                        item { FavoriteList(state.favoriteSessions) }
                        item { SectionHeader("Секции") }
                        items(state.sessionItems) { SessionItem(it) }
                    }
                }
            }
        }
    }
}