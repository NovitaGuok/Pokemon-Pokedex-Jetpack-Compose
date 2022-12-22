package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.GenerationI

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
