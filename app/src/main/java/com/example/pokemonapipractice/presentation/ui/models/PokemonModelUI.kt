package com.example.pokemonapipractice.presentation.ui.models

import com.example.pokemonapipractice.domain.models.PokemonModel

data class PokemonModelUI(
    val name: String,
)
fun PokemonModel.toUI() = PokemonModelUI(name)