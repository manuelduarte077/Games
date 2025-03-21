package dev.donmanuel.kotlinandroidtemplate.data.remote

import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import retrofit2.http.GET

interface GameApi {

    @GET("switch/games")
    suspend fun getSwitchGames(): List<Games>

    @GET("playstation/games")
    suspend fun getPlaystationGames(): List<Games>

    @GET("xbox/games")
    suspend fun getXboxGames(): List<Games>

}