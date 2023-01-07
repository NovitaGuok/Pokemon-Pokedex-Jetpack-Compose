package com.compose.pokemonapp.novita.domain.my_pokemon.repository

import com.compose.pokemonapp.novita.domain.common.model.MyPokemon
import kotlinx.coroutines.flow.Flow

interface MyPokemonRepository {
    fun getMyPokemonList(): Flow<List<MyPokemon>>
    fun deletePokemon(name: String)
}
