package dev.donmanuel.kotlinandroidtemplate.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_games")
data class FavoriteGame(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val developers: List<String>,
    val publishers: List<String>,
    val genre: List<String>,
    val releaseDates: Map<String, String>,
)