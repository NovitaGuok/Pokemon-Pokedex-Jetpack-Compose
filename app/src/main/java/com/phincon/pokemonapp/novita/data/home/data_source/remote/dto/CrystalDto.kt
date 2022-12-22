package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.Crystal

data class CrystalDto(

    @SerializedName("back_default")
    val backDefault: String = "",

    @SerializedName("back_shiny")
    val backShiny: String = "",

    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String = "",

    @SerializedName("back_transparent")
    val backTransparent: String = "",

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_shiny")
    val frontShiny: String = "",

    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String = "",

    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

fun CrystalDto.toModel() = Crystal(
    this.backDefault,
    this.backShiny,
    this.backShinyTransparent,
    this.backTransparent,
    this.frontDefault,
    this.frontShiny,
    this.frontShinyTransparent,
    this.frontTransparent,
)
