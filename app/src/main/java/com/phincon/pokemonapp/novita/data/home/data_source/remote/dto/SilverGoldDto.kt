package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.SilverGold

data class SilverGoldDto(

    @SerializedName("back_default")
    val backDefault: String = "",

    @SerializedName("back_shiny")
    val backShiny: String = "",

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_shiny")
    val frontShiny: String = "",

    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

fun SilverGoldDto.toModel() = SilverGold(
    this.backDefault,
    this.backShiny,
    this.frontDefault,
    this.frontShiny,
    this.frontTransparent
)
