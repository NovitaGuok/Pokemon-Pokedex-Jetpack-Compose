package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationV
import com.google.gson.annotations.SerializedName

data class GenerationVDto(
    @SerializedName("black-white")
    val blackWhite: BlackWhiteDto = BlackWhiteDto()
)

fun GenerationVDto.toModel() = GenerationV(
    this.blackWhite.toModel()
)
