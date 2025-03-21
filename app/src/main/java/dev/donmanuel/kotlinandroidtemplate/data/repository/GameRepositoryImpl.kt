package dev.donmanuel.kotlinandroidtemplate.data.repository

import dev.donmanuel.kotlinandroidtemplate.data.remote.GameApi
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gameApi: GameApi,
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

}