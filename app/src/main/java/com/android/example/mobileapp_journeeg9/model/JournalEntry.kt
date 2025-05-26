package com.android.example.mobileapp_journeeg9.model

import java.util.Date

data class JournalEntry(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val date: Date = Date(),
    val imageUrl: String? = null,
    val location: String? = null
)
