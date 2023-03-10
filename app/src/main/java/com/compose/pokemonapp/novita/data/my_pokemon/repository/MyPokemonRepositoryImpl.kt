package com.compose.pokemonapp.novita.data.my_pokemon.repository

import com.compose.pokemonapp.novita.data.detail.data_source.local.entity.toModel
import com.compose.pokemonapp.novita.data.my_pokemon.data_source.local.MyPokemonLocalDataSource
import com.compose.pokemonapp.novita.domain.common.model.MyPokemon
import com.compose.pokemonapp.novita.domain.my_pokemon.repository.MyPokemonRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyPokemonRepositoryImpl @Inject constructor(
    private val myPokemonLocalDataSource: MyPokemonLocalDataSource
) : MyPokemonRepository {
    override fun getMyPokemonList(): Flow<List<MyPokemon>> {
        return myPokemonLocalDataSource.getMyPokemonList()
            .map { pokemon -> pokemon.map { it.toModel() } }
    }

    override fun deletePokemon(name: String) {
        myPokemonLocalDataSource.deletePokemon(name)
    }
}
