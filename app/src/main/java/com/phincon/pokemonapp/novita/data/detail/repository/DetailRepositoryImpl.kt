package com.phincon.pokemonapp.novita.data.detail.repository

import com.phincon.pokemonapp.novita.data.detail.data_source.local.DetailLocalDataSource
import com.phincon.pokemonapp.novita.domain.common.model.Pokemon
import com.phincon.pokemonapp.novita.domain.common.model.toEntity
import com.phincon.pokemonapp.novita.domain.detail.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailLocalDataSource: DetailLocalDataSource
) : DetailRepository {
    override fun catchPokemon(pokemon: Pokemon) {
        detailLocalDataSource.catchPokemon(pokemon.toEntity())
    }
}
