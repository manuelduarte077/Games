package dev.donmanuel.kotlinandroidtemplate.domain.repository

import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGame
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    // Remote
    suspend fun getSwitchGames(): List<Games>
    suspend fun getPlaystationGames(): List<Games>
    suspend fun getXboxGames(): List<Games>

    // Local
    suspend fun addGameToFavorites(favoriteGame: FavoriteGame)
    suspend fun removeGameFromFavorites(favoriteGame: FavoriteGame)
    fun getAllFavoriteGames(): Flow<List<FavoriteGame>>

}