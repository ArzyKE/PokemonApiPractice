package com.example.pokemonapipractice.data.remote.network.apiservices

import com.example.pokemonapipractice.data.remote.network.dtos.PokemonDto
import com.example.pokemonapipractice.data.remote.network.dtos.PokemonResponseDto
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon() : PokemonResponseDto<PokemonDto>
}