package com.compose.pokemonapp.novita.data.home.repository

import com.compose.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.compose.pokemonapp.novita.data.home.data_source.remote.dto.toModel
import com.compose.pokemonapp.novita.domain.common.model.Pokemon
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.compose.pokemonapp.novita.domain.home.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getPokemonList(offset: Int): List<Pokemon> {
        return homeRemoteDataSource.getPokemonList(offset).map { it.toModel() }
    }

    override suspend fun getSpecificPokemon(name: String): SpecificPokemon {
        return homeRemoteDataSource.getSpecificPokemon(name)
    }
}
