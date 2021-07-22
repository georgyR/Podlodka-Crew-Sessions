package com.georgy_r.podlodkaandroidcrew.feature.session_info.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.georgy_r.podlodkaandroidcrew.common.data.mockSessionUiItem
import com.georgy_r.podlodkaandroidcrew.feature.home.model.SessionUiItem

@Composable
fun SessionInfoScreen(session: SessionUiItem.Session) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberImagePainter(session.imageUrl),
            contentScale = ContentScale.Crop,
            contentDescription = "Speaker Photo",
            modifier = Modifier
                .padding(horizontal = 64.dp)
                .aspectRatio(1f)
                .clip(shape = CircleShape)
        )
        Text(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(vertical = 16.dp),
            text = session.speaker,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(24.dp)
            )
            Text(
                text = "${session.date}, ${session.timeInterval}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }

        Text(
            text = session.description,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SessionInfoScreenPreview() {
    SessionInfoScreen(mockSessionUiItem)
}
