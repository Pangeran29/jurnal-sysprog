package org.d3if3030.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan")
data class Catatan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val topic: String,
    val journal: String,
    val book: String,
    val understand: String
)
