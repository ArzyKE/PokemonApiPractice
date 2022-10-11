package com.example.pokemonapipractice.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.pokemonapipractice.presentation.ui.base.BaseViewModel
import com.example.pokemonapipractice.presentation.state.UIState
import com.example.pokemonapipractice.domain.usecases.PokemonUseCase
import com.example.pokemonapipractice.presentation.models.PokemonModelUI
import com.example.pokemonapipractice.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val useCase: PokemonUseCase
) : BaseViewModel() {

    private val _pokemonState =
        MutableStateFlow<UIState<List<PokemonModelUI>>>(UIState.Loading())
    val pokemonState = _pokemonState.asStateFlow()

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() = viewModelScope.launch {
        _pokemonState.value = UIState.Loading()
        useCase().collectRequest(_pokemonState){
            it.map { it.toUI() }
        }
    }
}