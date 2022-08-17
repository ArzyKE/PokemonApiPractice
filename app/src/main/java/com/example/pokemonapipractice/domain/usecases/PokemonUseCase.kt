package com.example.pokemonapipractice.domain.usecases

import com.example.pokemonapipractice.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    operator fun invoke() = repository.fetchPokemon()

}