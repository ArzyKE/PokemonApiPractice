package com.example.pokemonapipractice.data.dtos

import com.example.pokemonapipractice.domain.models.PokemonResponse
import com.google.gson.annotations.SerializedName

data class PokemonResponseDto<T>(
    @SerializedName("results")
    val results: ArrayList<T>
)
fun <T> PokemonResponseDto<T>.toDomain() = PokemonResponse<T>(results)

