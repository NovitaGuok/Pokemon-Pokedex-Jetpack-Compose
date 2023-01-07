package com.compose.pokemonapp.novita.domain.home.repository

import com.compose.pokemonapp.novita.domain.common.model.Pokemon
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon

interface HomeRepository {
    suspend fun getPokemonList(offset: Int): List<Pokemon>
    suspend fun getSpecificPokemon(name: String): SpecificPokemon
}
