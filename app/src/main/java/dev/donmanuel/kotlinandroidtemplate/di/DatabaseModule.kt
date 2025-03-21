package dev.donmanuel.kotlinandroidtemplate.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.donmanuel.kotlinandroidtemplate.data.local.AppDatabase
import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGameDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "game_database"
        ).build()
    }

    @Provides
    fun provideGameDao(database: AppDatabase): FavoriteGameDao {
        return database.favoriteGameDao()
    }

}