package com.compose.pokemonapp.novita.domain.detail.repository

import com.compose.pokemonapp.novita.domain.common.model.MyPokemon

interface DetailRepository {
    fun catchPokemon(pokemon: MyPokemon)
    fun updateOwnedValue(name: String)
    fun isPokemonExist(name: String): Boolean
}
