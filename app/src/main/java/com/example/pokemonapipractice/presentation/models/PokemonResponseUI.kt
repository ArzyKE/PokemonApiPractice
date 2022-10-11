package com.example.pokemonapipractice.presentation.models

data class PokemonResponseUI<T>(
    val results: ArrayList<T>
)