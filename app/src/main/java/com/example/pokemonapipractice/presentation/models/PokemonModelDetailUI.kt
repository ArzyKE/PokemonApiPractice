package com.example.pokemonapipractice.presentation.models

import com.example.pokemonapipractice.domain.models.PokemonDetailModel

data class PokemonModelDetailUI(
    val name: String,
    val url: String,
    val pokemonId: Int = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        .replace("/", "").toInt()
)

fun PokemonDetailModel.toUI() = PokemonModelDetailUI(name, url)