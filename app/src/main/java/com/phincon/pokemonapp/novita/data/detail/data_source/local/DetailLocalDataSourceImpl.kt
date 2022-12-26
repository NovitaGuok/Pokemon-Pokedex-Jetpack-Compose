package com.phincon.pokemonapp.novita.data.detail.data_source.local

import com.phincon.pokemonapp.novita.data.detail.data_source.local.dao.DetailDao
import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.PokemonEntity
import javax.inject.Inject

class DetailLocalDataSourceImpl @Inject constructor(private val detailDao: DetailDao) :
    DetailLocalDataSource {
    override fun catchPokemon(pokemon: PokemonEntity) {
        detailDao.catchPokemon(pokemon)
    }
}
