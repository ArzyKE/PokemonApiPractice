package com.example.pokemonapipractice.presentation.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokemonapipractice.R
import com.example.pokemonapipractice.databinding.FragmentPokemonBinding
import com.example.pokemonapipractice.presentation.ui.adapters.PokemonAdapter
import com.example.pokemonapipractice.presentation.ui.base.BaseFragment
import com.example.pokemonapipractice.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment : BaseFragment<PokemonViewModel, FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        setupRecyclerview()
    }

    private fun setupRecyclerview() = with(binding.pokemonRecyclerview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = pokemonAdapter
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.pokemonState.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("arzymat", it.error)
                    }

                    is UIState.Success -> {
                        Log.e("anime", it.data.toString())
                        pokemonAdapter.submitList(it.data)
                    }
                }
            }
        }
    }
}