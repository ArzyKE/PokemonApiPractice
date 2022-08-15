package com.example.pokemonapipractice.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.pokemonapipractice.data.models.PokemonModel
import com.example.pokemonapipractice.data.repositories.PokemonRepository
import com.example.pokemonapipractice.ui.base.BaseViewModel
import com.example.pokemonapipractice.ui.state.UIState
import com.example.pokemonapipractice.utils.Either
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : BaseViewModel() {

    private val _pokemonstate =
        MutableStateFlow<UIState<ArrayList<PokemonModel>>>(UIState.Loading())
    val pokemonState = _pokemonstate.asStateFlow()

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() = viewModelScope.launch {
        _pokemonstate.value = UIState.Loading()
        repository.fetchPokemon().collect {
            when (it) {
                is Either.Left -> {
                    _pokemonstate.value = UIState.Error(it.value)
                }
                is Either.Right -> {
                    _pokemonstate.value = UIState.Success(it.value.results)
                }
            }
        }
    }
}