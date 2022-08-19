package com.example.pokemonapipractice.domain.repositories

import com.example.pokemonapipractice.domain.either.Either
import com.example.pokemonapipractice.domain.models.PokemonDetailModel
import com.example.pokemonapipractice.domain.models.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun fetchPokemon(): Flow<Either<String, List<PokemonModel>>>
    fun fetchPokemonName(name: String): Flow<Either<String, PokemonDetailModel>>
}