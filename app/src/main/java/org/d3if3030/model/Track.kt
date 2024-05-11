package org.d3if3030.model

import androidx.annotation.DrawableRes

data class Track(
    val topic: String,
    val book: String,
    val description: String,
    @DrawableRes val imageResId: Int
)