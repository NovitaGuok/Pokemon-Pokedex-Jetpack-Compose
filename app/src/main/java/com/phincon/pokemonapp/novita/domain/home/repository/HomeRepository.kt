package com.phincon.pokemonapp.novita.domain.home.repository

import com.phincon.pokemonapp.novita.domain.common.model.Pokemon
import com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon

interface HomeRepository {
    suspend fun getPokemonList(offset: Int): List<Pokemon>
    suspend fun getSpecificPokemon(name: String): SpecificPokemon
}
