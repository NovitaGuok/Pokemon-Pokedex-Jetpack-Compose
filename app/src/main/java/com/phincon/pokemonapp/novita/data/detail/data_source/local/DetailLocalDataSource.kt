package com.phincon.pokemonapp.novita.data.detail.data_source.local

import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.MyPokemonEntity

interface DetailLocalDataSource {
    fun catchPokemon(pokemon: MyPokemonEntity)
    fun updateOwnedValue(name: String)
    fun isPokemonExist(name: String): Boolean
}
