package com.example.pokemonapipractice.domain.usecases

import com.example.pokemonapipractice.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonDetailUsaCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(name: String) = repository.fetchPokemonName(name)
}