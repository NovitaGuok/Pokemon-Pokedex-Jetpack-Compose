package com.phincon.pokemonapp.novita.data.home.data_source.remote

import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.PokemonDto
import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.toModel
import com.phincon.pokemonapp.novita.data.home.data_source.remote.service.HomeService
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(private val homeService: HomeService) :
    HomeRemoteDataSource {
    override suspend fun getPokemonList(): List<PokemonDto> {
        return homeService.getPokemonList().body()?.results ?: listOf()
    }

    override suspend fun getSpecificPokemon(name: String): SpecificPokemon {
        return homeService.getSpecificPokemon(name).body()?.toModel() ?: SpecificPokemon()
    }
}
