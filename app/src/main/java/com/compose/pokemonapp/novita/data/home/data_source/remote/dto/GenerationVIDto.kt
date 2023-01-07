package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationVI
import com.google.gson.annotations.SerializedName

data class GenerationVIDto(

    @SerializedName("omegaruby-alphasapphire")
    val omegaRubyAlphaSapphire: XYDto = XYDto(),

    @SerializedName("x-y")
    val xy: XYDto = XYDto()
)

fun GenerationVIDto.toModel() = GenerationVI(
    this.omegaRubyAlphaSapphire.toModel(),
    this.xy.toModel()
)
