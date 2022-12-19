package com.phincon.pokemonapp.novita.data.home.repository

import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.toModel
import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
import com.phincon.pokemonapp.novita.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getPokemonList(): List<Pokemon> {
        return homeRemoteDataSource.getPokemonList().map { it.toModel() }
    }

    override suspend fun getSpecificPokemon(name: String): SpecificPokemon {
        return homeRemoteDataSource.getSpecificPokemon(name)
    }
}
