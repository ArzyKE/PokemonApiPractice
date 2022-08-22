package com.example.pokemonapipractice.presentation.ui.fragments.detail

import androidx.lifecycle.viewModelScope
import com.example.pokemonapipractice.domain.usecases.PokemonDetailUsaCase
import com.example.pokemonapipractice.presentation.models.PokemonModelDetailUI
import com.example.pokemonapipractice.presentation.models.toUI
import com.example.pokemonapipractice.presentation.state.UIState
import com.example.pokemonapipractice.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val useCase: PokemonDetailUsaCase
) : BaseViewModel() {

    private val _pokemonDetailState =
        MutableStateFlow<UIState<PokemonModelDetailUI>>(UIState.Loading())
    val pokemonDetailState = _pokemonDetailState.asStateFlow()

    fun fetchPokemonDetail(name: String) = viewModelScope.launch {
        _pokemonDetailState.value = UIState.Loading()
        useCase(name).collectRequest(_pokemonDetailState) {
            it.toUI()
        }
    }
}
