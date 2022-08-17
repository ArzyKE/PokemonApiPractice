package com.example.pokemonapipractice.presentation.models

import com.example.pokemonapipractice.domain.models.PokemonModel

data class PokemonModelUI(
    val name: String,
    val url: String,
    val pokemonId: Int = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        .replace("/", "").toInt()
)
fun PokemonModel.toUI() = PokemonModelUI(name,url)