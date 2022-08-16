package com.example.pokemonapipractice.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.pokemonapipractice.data.dtos.PokemonDto
import com.example.pokemonapipractice.data.repositories.PokemonRepositoryImpl
import com.example.pokemonapipractice.presentation.ui.base.BaseViewModel
import com.example.pokemonapipractice.presentation.ui.state.UIState
import com.example.pokemonapipractice.domain.either.Either
import com.example.pokemonapipractice.domain.usecases.PokemonUseCase
import com.example.pokemonapipractice.presentation.ui.models.PokemonModelUI
import com.example.pokemonapipractice.presentation.ui.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val useCase: PokemonUseCase
) : BaseViewModel() {

    private val _pokemonstate =
        MutableStateFlow<UIState<List<PokemonModelUI>>>(UIState.Loading())
    val pokemonState = _pokemonstate.asStateFlow()

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() = viewModelScope.launch {
        _pokemonstate.value = UIState.Loading()
        useCase().collectRequest(_pokemonstate){
            it.map { it.toUI() }
        }
    }
}