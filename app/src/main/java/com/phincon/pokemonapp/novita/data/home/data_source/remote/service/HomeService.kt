package com.phincon.pokemonapp.novita.data.home.data_source.remote.service

import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.PokemonResponse
import com.phincon.pokemonapp.novita.data.home.data_source.remote.dto.SpecificPokemonResponse
import com.phincon.pokemonapp.novita.util.UrlRoute.POKEMON_LIST_URL
import com.phincon.pokemonapp.novita.util.UrlRoute.SPECIFIC_POKEMON_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    @GET(POKEMON_LIST_URL)
    suspend fun getPokemonList(): Response<PokemonResponse>

    @GET(SPECIFIC_POKEMON_URL)
    suspend fun getSpecificPokemon(@Path("name") name: String): Response<SpecificPokemonResponse>
}
