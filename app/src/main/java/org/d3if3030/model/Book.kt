package org.d3if3030.model

import androidx.annotation.DrawableRes

data class Book(
    val title: String,
    @DrawableRes val imageResId: Int
)
