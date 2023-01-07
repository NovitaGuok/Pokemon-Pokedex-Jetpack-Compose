package com.compose.pokemonapp.novita.data.home.data_source.remote

import com.compose.pokemonapp.novita.data.home.data_source.remote.dto.PokemonDto
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon

interface HomeRemoteDataSource {
    suspend fun getPokemonList(offset: Int): List<PokemonDto>
    suspend fun getSpecificPokemon(name: String): SpecificPokemon
}
