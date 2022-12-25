package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.Color

data class ColorDto(

    @SerializedName("back_default")
    val backDefault: String = "",

    @SerializedName("back_gray")
    val backGray: String = "",

    @SerializedName("back_transparent")
    val backTransparent: String = "",

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_gray")
    val frontGray: String = "",

    @SerializedName("front_transparent")
    val frontTransparent: String = ""
)

fun ColorDto.toModel() = Color(
    this.backDefault,
    this.backGray,
    this.backTransparent,
    this.frontDefault,
    this.frontGray,
    this.frontTransparent
)
