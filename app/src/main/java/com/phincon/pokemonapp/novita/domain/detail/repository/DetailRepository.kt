package com.phincon.pokemonapp.novita.domain.detail.repository

import com.phincon.pokemonapp.novita.domain.common.model.Pokemon

interface DetailRepository {
    fun catchPokemon(pokemon: Pokemon)
}
