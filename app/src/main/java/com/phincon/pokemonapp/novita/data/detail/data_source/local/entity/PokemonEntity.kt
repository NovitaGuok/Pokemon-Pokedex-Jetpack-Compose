package com.phincon.pokemonapp.novita.data.detail.data_source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.phincon.pokemonapp.novita.domain.common.model.Pokemon

@Entity(tableName = "Pokemon")
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "url")
    val url: String = ""
)

fun PokemonEntity.toModel() = Pokemon(
    this.name,
    this.url
)
