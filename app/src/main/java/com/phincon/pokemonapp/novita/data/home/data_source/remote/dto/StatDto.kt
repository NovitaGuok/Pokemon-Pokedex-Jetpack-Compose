package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.Stat

data class StatDto(

    @SerializedName("base_stat")
    val baseStat: Int = 0,

    @SerializedName("effort")
    val effort: Int = 0,

    @SerializedName("stat")
    val stat: PokemonDto = PokemonDto()
)

fun StatDto.toModel() = Stat(
    this.baseStat,
    this.effort,
    this.stat.toModel()
)
