package com.phincon.pokemonapp.novita.data.detail.data_source.local

import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.PokemonEntity

interface DetailLocalDataSource {
    fun catchPokemon(pokemon: PokemonEntity)
}
