package dev.donmanuel.kotlinandroidtemplate.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGameToFavorites(favoriteGame: FavoriteGame)

    @Delete
    suspend fun removeGameFromFavorites(favoriteGame: FavoriteGame)

    @Query("SELECT * FROM favorite_games")
    fun getAllFavoriteGames(): Flow<List<FavoriteGame>>

}