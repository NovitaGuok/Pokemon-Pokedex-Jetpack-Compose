package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.Emerald

data class EmeraldDto(

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

fun EmeraldDto.toModel() = Emerald(
    this.frontDefault,
    this.frontShiny
)
