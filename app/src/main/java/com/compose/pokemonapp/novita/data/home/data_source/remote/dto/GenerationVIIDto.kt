package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationVII
import com.google.gson.annotations.SerializedName

data class GenerationVIIDto(

    @SerializedName("icons")
    val icons: IconsDto = IconsDto(),

    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: XYDto = XYDto()
)

fun GenerationVIIDto.toModel() = GenerationVII(
    this.icons.toModel(),
    this.ultraSunUltraMoon.toModel()
)
