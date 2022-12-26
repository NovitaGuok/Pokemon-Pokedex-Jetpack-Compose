package com.phincon.pokemonapp.novita.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phincon.pokemonapp.novita.BuildConfig.DB_VERSION
import com.phincon.pokemonapp.novita.data.detail.data_source.local.dao.DetailDao
import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.PokemonEntity
import com.phincon.pokemonapp.novita.data.my_pokemon.data_source.local.dao.MyPokemonDao

@Database(entities = [PokemonEntity::class], version = DB_VERSION)
abstract class AppDb : RoomDatabase() {
    abstract fun myPokemonDao(): MyPokemonDao
    abstract fun detailDao(): DetailDao
}
