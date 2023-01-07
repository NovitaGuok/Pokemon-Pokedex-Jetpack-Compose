package com.compose.pokemonapp.novita.data.home.data_source.remote

import com.compose.pokemonapp.novita.data.home.data_source.remote.dto.PokemonDto
import com.compose.pokemonapp.novita.data.home.data_source.remote.dto.toModel
import com.compose.pokemonapp.novita.data.home.data_source.remote.service.HomeService
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(private val homeService: HomeService) :
    HomeRemoteDataSource {
    override suspend fun getPokemonList(offset: Int): List<PokemonDto> {
        return homeService.getPokemonList(offset).body()?.results ?: listOf()
    }

    override suspend fun getSpecificPokemon(name: String): SpecificPokemon {
        return homeService.getSpecificPokemon(name).body()?.toModel() ?: SpecificPokemon()
    }
}
