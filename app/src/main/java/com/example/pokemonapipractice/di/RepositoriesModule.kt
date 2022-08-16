package com.example.pokemonapipractice.di

import com.example.pokemonapipractice.data.repositories.PokemonRepositoryImpl
import com.example.pokemonapipractice.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun providePokemonRepository(repositoryImpl: PokemonRepositoryImpl): PokemonRepository
}