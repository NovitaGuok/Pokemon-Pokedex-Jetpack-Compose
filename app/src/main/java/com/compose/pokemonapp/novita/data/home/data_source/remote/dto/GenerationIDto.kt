package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationI
import com.google.gson.annotations.SerializedName

data class GenerationIDto(

    @SerializedName("red-blue")
    val redBlue: ColorDto = ColorDto(),

    @SerializedName("yellow")
    val yellow: ColorDto = ColorDto()
)

fun GenerationIDto.toModel() = GenerationI(
    this.redBlue.toModel(),
    this.yellow.toModel()
)
