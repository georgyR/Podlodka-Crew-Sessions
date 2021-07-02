package com.georgy_r.podlodkaandroidcrew.presentation

import com.georgy_r.podlodkaandroidcrew.data.Session
import com.georgy_r.podlodkaandroidcrew.presentation.model.SessionUiItem

class SessionUiItemsConverter {

    fun convertToSessionItems(items: List<Session>): List<SessionUiItem> {
        val sessionUiItems = mutableListOf<SessionUiItem>()

        var lastDate: String? = null
        for (session in items) {
            val date = session.date
            if (date != lastDate) {
                lastDate = date
                sessionUiItems.add(SessionUiItem.Date(date))
            }

            val uiSession = SessionUiItem.Session(
                id = session.id,
                speaker = session.speaker,
                date = session.date,
                timeInterval = session.timeInterval,
                description = session.description,
                imageUrl = session.imageUrl
            )
            sessionUiItems.add(uiSession)
        }

        return sessionUiItems
    }

    fun convertToSimpleItems(items: List<Session>): List<SessionUiItem.Session> {
        return items.map { session ->
            SessionUiItem.Session(
                id = session.id,
                speaker = session.speaker,
                date = session.date,
                timeInterval = session.timeInterval,
                description = session.description,
                imageUrl = session.imageUrl
            )
        }
    }
}