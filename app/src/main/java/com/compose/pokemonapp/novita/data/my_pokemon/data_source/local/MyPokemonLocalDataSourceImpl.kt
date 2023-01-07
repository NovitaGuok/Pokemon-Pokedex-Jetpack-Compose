package com.compose.pokemonapp.novita.data.my_pokemon.data_source.local

import com.compose.pokemonapp.novita.data.detail.data_source.local.entity.MyPokemonEntity
import com.compose.pokemonapp.novita.data.my_pokemon.data_source.local.dao.MyPokemonDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MyPokemonLocalDataSourceImpl @Inject constructor(private val myPokemonDao: MyPokemonDao) :
    MyPokemonLocalDataSource {
    override fun getMyPokemonList(): Flow<List<MyPokemonEntity>> {
        return myPokemonDao.getMyPokemonList()
    }

    override fun deletePokemon(name: String) {
        myPokemonDao.deletePokemon(name)
    }
}
