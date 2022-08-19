package com.example.pokemonapipractice.data.remote.network.apiservices

import com.example.pokemonapipractice.data.remote.network.dtos.PokemonDetailModelDto
import com.example.pokemonapipractice.data.remote.network.dtos.PokemonDto
import com.example.pokemonapipractice.data.remote.network.dtos.PokemonResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon(): PokemonResponseDto<PokemonDto>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonName(
        @Path("name") name: String
    ): PokemonDetailModelDto
}