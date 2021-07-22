package com.georgy_r.podlodkaandroidcrew.feature.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.georgy_r.podlodkaandroidcrew.feature.home.HomeViewModel
import com.georgy_r.podlodkaandroidcrew.feature.home.model.HomeUiState

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state.observeAsState().value ?: HomeUiState.EMPTY
    LazyColumn(
        Modifier.padding(vertical = 8.dp)
    ) {
        if (state.favoriteSessions.isNotEmpty()) {
            item { SectionHeader("Избранное") }
        }
        item { FavoriteList(state.favoriteSessions) }
        item { SectionHeader("Секции") }
        items(state.sessionItems) { SessionItem(it, viewModel::onFavoriteClicked) }
    }
}
