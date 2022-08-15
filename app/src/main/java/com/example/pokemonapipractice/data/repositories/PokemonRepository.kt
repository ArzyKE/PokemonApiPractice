package com.example.pokemonapipractice.data.repositories

import com.example.pokemonapipractice.data.remote.apiservices.PokemonApiService
import com.example.pokemonapipractice.data.repositories.base.BaseRepository
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiService
) : BaseRepository() {

    fun fetchPokemon() = doRequest {
        apiService.fetchPokemon()
    }
}