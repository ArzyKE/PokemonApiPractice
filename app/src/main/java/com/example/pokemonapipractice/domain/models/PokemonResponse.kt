package com.example.pokemonapipractice.domain.models

data class PokemonResponse<T>(
    val results: List<T>
)