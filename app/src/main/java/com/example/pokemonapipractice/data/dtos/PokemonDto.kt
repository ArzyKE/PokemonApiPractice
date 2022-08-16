package com.example.pokemonapipractice.data.dtos

import com.example.pokemonapipractice.domain.models.PokemonModel
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String
)
fun PokemonDto.toDomain() = PokemonModel(name)