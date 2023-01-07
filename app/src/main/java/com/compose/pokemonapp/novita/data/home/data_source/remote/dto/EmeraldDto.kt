package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.Emerald
import com.google.gson.annotations.SerializedName

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
