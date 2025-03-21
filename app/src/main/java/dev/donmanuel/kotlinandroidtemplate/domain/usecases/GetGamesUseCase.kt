package dev.donmanuel.kotlinandroidtemplate.domain.usecases

import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val gameRepository: GameRepository

) {
    suspend fun getXboxGames(): List<Games> {
        return gameRepository.getXboxGames()
    }
}