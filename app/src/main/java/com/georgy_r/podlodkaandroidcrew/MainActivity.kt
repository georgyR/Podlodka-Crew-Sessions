package com.georgy_r.podlodkaandroidcrew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.georgy_r.podlodkaandroidcrew.common.base_ui.theme.PodlodkaAndroidCrewTheme
import com.georgy_r.podlodkaandroidcrew.feature.home.HomeViewModel
import com.georgy_r.podlodkaandroidcrew.feature.home.ui.HomeScreen

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaAndroidCrewTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(viewModel)
                }
            }
        }
    }
}
