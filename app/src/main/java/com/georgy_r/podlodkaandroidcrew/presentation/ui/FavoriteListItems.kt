package com.georgy_r.podlodkaandroidcrew.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.georgy_r.podlodkaandroidcrew.data.mockSessionUiItem
import com.georgy_r.podlodkaandroidcrew.presentation.model.SessionUiItem

private const val descriptionLineCount = 3

@Composable
fun FavoriteList(sessions: List<SessionUiItem.Session>) {
    LazyRow(Modifier.padding(horizontal = 8.dp)) {
        items(sessions) { FavoriteCards(session = it) }
    }
}

@Composable
fun FavoriteCards(session: SessionUiItem.Session) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .width(150.dp)

    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = session.timeInterval,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = session.date,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = session.speaker,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            LocalTextStyle.current.fontStyle
            Text(
                text = session.description,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = descriptionLineCount,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(((14 * descriptionLineCount).toApproxLineHeight()).sp.toDp())
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FavoriteCardsPreview() {
    FavoriteCards(session = mockSessionUiItem)
}

@Composable
// Copy-past from androidx.compose.ui.unit.Density.toDp. Can't import
private fun TextUnit.toDp(): Dp {
    return Dp(value * LocalDensity.current.fontScale)
}

private fun Int.toApproxLineHeight(): Double = this.toDouble() * 4 / 3


