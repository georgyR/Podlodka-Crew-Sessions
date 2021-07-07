package com.georgy_r.podlodkaandroidcrew.feature.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.georgy_r.podlodkaandroidcrew.common.data.mockSessionUiItem
import com.georgy_r.podlodkaandroidcrew.feature.home.model.SessionUiItem
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun SessionItem(item: SessionUiItem, onFavoriteChanged: (id: String) -> Unit) {
    when (item) {
        is SessionUiItem.Session -> SessionCard(item, onFavoriteChanged)
        is SessionUiItem.Date -> SessionDate(item.title)
    }
}

@Composable
fun SessionCard(session: SessionUiItem.Session, onFavoriteChanged: (id: String) -> Unit) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberCoilPainter(request = session.imageUrl),
                contentScale = ContentScale.Crop,
                contentDescription = "Speaker Photo",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(64.dp)
                    .clip(shape = CircleShape)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
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
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
                tint = if (session.isFavorite) Color.Red else Color.Gray,
                modifier = Modifier
                    .size(56.dp)
                    .clickable(
                        indication = rememberRipple(bounded = false),
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { onFavoriteChanged.invoke(session.id) }
                    )
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun SessionDate(title: String) {
    Text(
        text = title,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
private fun PreviewSessionCard() {
    SessionCard(session = mockSessionUiItem) {}
}

@Preview(showBackground = true)
@Composable
private fun PreviewSessionDate() {
    SessionDate(title = "19 апреля")
}