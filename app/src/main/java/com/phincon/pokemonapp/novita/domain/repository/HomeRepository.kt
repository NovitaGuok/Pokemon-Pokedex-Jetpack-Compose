package com.phincon.pokemonapp.novita.domain.repository

import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon

interface HomeRepository {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getSpecificPokemon(name: String): SpecificPokemon
}
