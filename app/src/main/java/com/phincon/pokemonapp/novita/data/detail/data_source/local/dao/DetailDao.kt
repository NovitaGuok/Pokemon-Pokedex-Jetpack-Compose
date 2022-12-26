package com.phincon.pokemonapp.novita.data.detail.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.PokemonEntity

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun catchPokemon(pokemon: PokemonEntity)
}
