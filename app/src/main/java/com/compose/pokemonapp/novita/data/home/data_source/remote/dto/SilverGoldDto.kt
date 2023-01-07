package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.SilverGold
import com.google.gson.annotations.SerializedName

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
