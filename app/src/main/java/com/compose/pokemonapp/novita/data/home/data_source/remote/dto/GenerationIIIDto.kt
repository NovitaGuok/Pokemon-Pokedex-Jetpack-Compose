package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationIII
import com.google.gson.annotations.SerializedName

data class GenerationIIIDto(
    @SerializedName("emerald")
    val emerald: EmeraldDto = EmeraldDto(),

    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: RubySapphireDto = RubySapphireDto(),

    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphireDto = RubySapphireDto()
)

fun GenerationIIIDto.toModel() = GenerationIII(
    this.emerald.toModel(),
    this.fireredLeafgreen.toModel(),
    this.rubySapphire.toModel()
)
