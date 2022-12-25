package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.RubySapphire

data class RubySapphireDto(
    @SerializedName("back_default")
    val backDefault: String = "",

    @SerializedName("back_shiny")
    val backShiny: String = "",

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_shiny")
    val frontShiny: String = ""
)

fun RubySapphireDto.toModel() = RubySapphire(
    this.backDefault,
    this.backShiny,
    this.frontDefault,
    this.frontShiny
)
