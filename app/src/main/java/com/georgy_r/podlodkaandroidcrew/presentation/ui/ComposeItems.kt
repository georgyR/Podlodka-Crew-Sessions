package com.georgy_r.podlodkaandroidcrew.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.georgy_r.podlodkaandroidcrew.data.Session
import com.georgy_r.podlodkaandroidcrew.data.mockSessions
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun SessionList(sessions: List<Session>) {
    LazyColumn {
        items(sessions) { SessionCard(it) }
    }
}

@Composable
fun SessionCard(session: Session) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = CircleShape),
                painter = rememberCoilPainter(request = session.imageUrl),
                contentScale = ContentScale.Crop,
                contentDescription = "Speaker Photo",
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = session.speaker,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = session.timeInterval,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = session.description,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
                tint = Color.Gray,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSessionCard() {
    SessionCard(session = mockSessions.first())
}