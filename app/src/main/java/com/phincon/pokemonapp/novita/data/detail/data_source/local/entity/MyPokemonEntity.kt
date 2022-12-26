package com.phincon.pokemonapp.novita.data.detail.data_source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.phincon.pokemonapp.novita.domain.common.model.MyPokemon

@Entity(tableName = "Pokemon")
data class MyPokemonEntity(
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "img_url")
    val imgUrl: String = "",

    @ColumnInfo(name = "owned")
    val owned: Int = 0,
)

fun MyPokemonEntity.toModel() = MyPokemon(
    this.id,
    this.name,
    this.imgUrl,
    this.owned
)
