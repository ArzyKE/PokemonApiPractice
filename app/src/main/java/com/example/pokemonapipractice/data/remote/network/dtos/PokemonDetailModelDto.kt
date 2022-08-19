package com.example.pokemonapipractice.data.remote.network.dtos

import com.example.pokemonapipractice.domain.models.PokemonDetailModel
import com.google.gson.annotations.SerializedName

data class PokemonDetailModelDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String

)

fun PokemonDetailModelDto.toDomain() = PokemonDetailModel(name, url)