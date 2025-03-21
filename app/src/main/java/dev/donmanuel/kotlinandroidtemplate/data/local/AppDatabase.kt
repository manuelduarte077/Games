package dev.donmanuel.kotlinandroidtemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.donmanuel.kotlinandroidtemplate.ui.utils.Converters

@Database(entities = [FavoriteGame::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteGameDao(): FavoriteGameDao
}