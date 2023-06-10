package com.example.pokemonapipractice.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapipractice.databinding.ItemPokemonBinding
import com.example.pokemonapipractice.presentation.models.PokemonModelUI

class PokemonAdapter : ListAdapter<PokemonModelUI, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PokemonAdapter.PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class PokemonViewHolder(
        private val binding: ItemPokemonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PokemonModelUI) {
            binding.pokemonNameItem.text = item.name
            Glide.with(binding.imPokemon.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.pokemonId}.png")
                .into(binding.imPokemon)
        }
    }
}//

object PokemonDiffCallBack : DiffUtil.ItemCallback<PokemonModelUI>() {
    override fun areItemsTheSame(
        oldItem: PokemonModelUI,
        newItem: PokemonModelUI
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: PokemonModelUI,
        newItem: PokemonModelUI
    ): Boolean {
        return oldItem == newItem
    }
}