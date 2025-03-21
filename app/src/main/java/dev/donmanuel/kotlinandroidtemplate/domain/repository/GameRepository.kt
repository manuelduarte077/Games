package dev.donmanuel.kotlinandroidtemplate.domain.repository

import dev.donmanuel.kotlinandroidtemplate.domain.model.Games

interface GameRepository {

    // Remote
    suspend fun getSwitchGames(): List<Games>
    suspend fun getPlaystationGames(): List<Games>
    suspend fun getXboxGames(): List<Games>

}