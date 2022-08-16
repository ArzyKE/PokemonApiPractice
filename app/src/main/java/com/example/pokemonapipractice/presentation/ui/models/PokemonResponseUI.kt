package com.example.pokemonapipractice.presentation.ui.models

data class PokemonResponseUI<T>(
    val results: ArrayList<T>
)