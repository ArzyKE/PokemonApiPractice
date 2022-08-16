package com.example.pokemonapipractice.data.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse<T>(
    @SerializedName("results")
    val results: ArrayList<T>
)