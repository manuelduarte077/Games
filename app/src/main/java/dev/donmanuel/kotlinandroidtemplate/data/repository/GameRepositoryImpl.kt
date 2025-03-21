package dev.donmanuel.kotlinandroidtemplate.data.repository

import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGame
import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGameDao
import dev.donmanuel.kotlinandroidtemplate.data.remote.GameApi
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gameApi: GameApi,
    private val favoriteGameDao: FavoriteGameDao
) : GameRepository {

    override suspend fun getSwitchGames(): List<Games> {
        return gameApi.getSwitchGames()
    }

    override suspend fun getPlaystationGames(): List<Games> {
        return gameApi.getPlaystationGames()
    }

    override suspend fun getXboxGames(): List<Games> {
        return gameApi.getXboxGames()
    }

    override suspend fun addGameToFavorites(favoriteGame: FavoriteGame) {
        return favoriteGameDao.addGameToFavorites(favoriteGame)
    }

    override suspend fun removeGameFromFavorites(favoriteGame: FavoriteGame) {
        return favoriteGameDao.removeGameFromFavorites(favoriteGame)
    }

    override fun getAllFavoriteGames(): Flow<List<FavoriteGame>> {
        return favoriteGameDao.getAllFavoriteGames()
    }

}