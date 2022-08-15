package com.example.pokemonapipractice.data.remote.apiservices

import com.example.pokemonapipractice.data.models.PokemonModel
import com.example.pokemonapipractice.data.models.PokemonResponse
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon() : PokemonResponse<PokemonModel>
}