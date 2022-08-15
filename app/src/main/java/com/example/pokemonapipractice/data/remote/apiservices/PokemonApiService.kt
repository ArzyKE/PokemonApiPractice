package com.example.pokemonapipractice.data.remote.apiservices

import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon()
}