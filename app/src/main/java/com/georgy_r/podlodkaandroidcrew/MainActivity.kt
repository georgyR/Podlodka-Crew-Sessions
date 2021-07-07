package com.georgy_r.podlodkaandroidcrew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.georgy_r.podlodkaandroidcrew.feature.home.HomeViewModel
import com.georgy_r.podlodkaandroidcrew.feature.home.ui.HomeScreen

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(viewModel)
        }
    }
}