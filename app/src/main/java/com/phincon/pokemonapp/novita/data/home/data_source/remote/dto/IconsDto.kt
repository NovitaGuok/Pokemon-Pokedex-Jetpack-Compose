package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.Icons

data class IconsDto(

    @SerializedName("front_default")
    val frontDefault: String = "",

    @SerializedName("front_female")
    val frontFemale: Any? = null
)

fun IconsDto.toModel() = Icons(
    this.frontDefault,
    this.frontFemale
)
