package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.GenerationV

data class GenerationVDto(
    @SerializedName("black-white")
    val blackWhite: BlackWhiteDto = BlackWhiteDto()
)

fun GenerationVDto.toModel() = GenerationV(
    this.blackWhite.toModel()
)
