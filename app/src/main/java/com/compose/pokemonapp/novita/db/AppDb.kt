package com.compose.pokemonapp.novita.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.pokemonapp.novita.BuildConfig.DB_VERSION
import com.compose.pokemonapp.novita.data.detail.data_source.local.dao.DetailDao
import com.compose.pokemonapp.novita.data.detail.data_source.local.entity.MyPokemonEntity
import com.compose.pokemonapp.novita.data.my_pokemon.data_source.local.dao.MyPokemonDao

@Database(entities = [MyPokemonEntity::class], version = DB_VERSION)
abstract class AppDb : RoomDatabase() {
    abstract fun myPokemonDao(): MyPokemonDao
    abstract fun detailDao(): DetailDao
}
