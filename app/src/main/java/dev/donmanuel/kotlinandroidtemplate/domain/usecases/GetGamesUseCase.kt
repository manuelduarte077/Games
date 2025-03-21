package dev.donmanuel.kotlinandroidtemplate.domain.usecases

import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGame
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend fun getXboxGames(): List<Games> {
        return gameRepository.getXboxGames()
    }

    suspend fun getPlaystationGames(): List<Games> {
        return gameRepository.getPlaystationGames()
    }

    suspend fun getSwitchGames(): List<Games> {
        return gameRepository.getSwitchGames()
    }

    fun getAllFavorites() = gameRepository.getAllFavoriteGames()

    suspend fun addGameToFavorites(favoriteGame: FavoriteGame) {
        return gameRepository.addGameToFavorites(favoriteGame)
    }

    suspend fun removeGameFromFavorites(favoriteGame: FavoriteGame) {
        return gameRepository.removeGameFromFavorites(favoriteGame)
    }
}