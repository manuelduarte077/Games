package dev.donmanuel.kotlinandroidtemplate.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.donmanuel.kotlinandroidtemplate.data.repository.GameRepositoryImpl
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCartoonRepository(
        impl: GameRepositoryImpl
    ): GameRepository

}