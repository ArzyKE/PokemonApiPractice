package com.example.pokemonapipractice.data.remote.apiservices

import com.example.pokemonapipractice.data.dtos.PokemonDto
import com.example.pokemonapipractice.data.dtos.PokemonResponseDto
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon() : PokemonResponseDto<PokemonDto>
}