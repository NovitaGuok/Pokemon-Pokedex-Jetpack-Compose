package com.phincon.pokemonapp.novita.data.home.data_source.remote

import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.PokemonDto
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon

interface HomeRemoteDataSource {
    suspend fun getPokemonList(offset: Int): List<PokemonDto>
    suspend fun getSpecificPokemon(name: String): SpecificPokemon
}
