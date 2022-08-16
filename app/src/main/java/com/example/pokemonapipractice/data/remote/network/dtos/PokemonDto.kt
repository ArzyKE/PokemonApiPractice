package com.example.pokemonapipractice.data.remote.network.dtos

import com.example.pokemonapipractice.domain.models.PokemonModel
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
fun PokemonDto.toDomain() = PokemonModel(name,url)