package com.example.pokemonapipractice.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapipractice.data.models.PokemonModel
import com.example.pokemonapipractice.databinding.ItemPokemonBinding

class PokemonAdapter : ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
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
        fun onBind(item: PokemonModel?) {
            binding.pokemonNameItem.text = item?.name
        }
    }
}

object PokemonDiffCallBack : DiffUtil.ItemCallback<PokemonModel>() {
    override fun areItemsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel
    ): Boolean {
        return oldItem == newItem
    }
}