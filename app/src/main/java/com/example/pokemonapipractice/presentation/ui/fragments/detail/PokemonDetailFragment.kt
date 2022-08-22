package com.example.pokemonapipractice.presentation.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.pokemonapipractice.R
import com.example.pokemonapipractice.databinding.FragmentPokemonDetailBinding
import com.example.pokemonapipractice.presentation.state.UIState
import com.example.pokemonapipractice.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonDetailFragment :
    BaseFragment<PokemonDetailViewModel, FragmentPokemonDetailBinding>(R.layout.fragment_pokemon_detail) {

    override val binding by viewBinding(FragmentPokemonDetailBinding::bind)
    override val viewModel: PokemonDetailViewModel by viewModels()
    private val args by navArgs<PokemonDetailFragmentArgs>()

    override fun setupRequests() {
        viewModel.fetchPokemonDetail(args.position)
        lifecycleScope.launch {
            viewModel.pokemonDetailState.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("arzymat", it.error)
                    }

                    is UIState.Success -> {
                        Log.e("anime", it.data.toString())
                        binding.pokemonDetailName.text = it.data.name
                        Glide.with(binding.imAva)
                            .load(it.data.pokemonId)
                            .into(binding.imAva)
                        Log.e("tag", it.data.name.toString())
                        Log.e("image", it.data.pokemonId.toString())
                    }
                }
            }
        }
    }
}