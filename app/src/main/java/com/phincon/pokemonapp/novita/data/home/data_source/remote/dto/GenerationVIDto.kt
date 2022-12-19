package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.GenerationVI

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
