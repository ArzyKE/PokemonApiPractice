package com.example.pokemonapipractice.data.repositories

import com.example.pokemonapipractice.data.remote.network.apiservices.PokemonApiService
import com.example.pokemonapipractice.data.remote.network.dtos.toDomain
import com.example.pokemonapipractice.data.repositories.base.BaseRepository
import com.example.pokemonapipractice.domain.either.Either
import com.example.pokemonapipractice.domain.models.PokemonDetailModel
import com.example.pokemonapipractice.domain.models.PokemonModel
import com.example.pokemonapipractice.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: PokemonApiService
) : BaseRepository(), PokemonRepository {

    override fun fetchPokemon(): Flow<Either<String, List<PokemonModel>>> = doRequest {
        apiService.fetchPokemon().results.map { it.toDomain() }
    }

    override fun fetchPokemonName(name: String): Flow<Either<String, PokemonDetailModel>> =
        doRequest {
            apiService.fetchPokemonName(name).toDomain()
        }
}