package com.example.pokemonapipractice.domain.repositories

import com.example.pokemonapipractice.domain.either.Either
import com.example.pokemonapipractice.domain.models.PokemonModel
import com.example.pokemonapipractice.domain.models.PokemonResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun fetchPokemon() : Flow<Either<String,List<PokemonModel>>>
}