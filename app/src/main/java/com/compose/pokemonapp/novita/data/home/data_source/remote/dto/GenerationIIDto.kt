package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.GenerationII
import com.google.gson.annotations.SerializedName

data class GenerationIIDto(

    @SerializedName("crystal")
    val crystal: CrystalDto = CrystalDto(),

    @SerializedName("gold")
    val gold: SilverGoldDto = SilverGoldDto(),

    @SerializedName("silver")
    val silver: SilverGoldDto = SilverGoldDto()
)

fun GenerationIIDto.toModel() = GenerationII(
    this.crystal.toModel(),
    this.gold.toModel(),
    this.silver.toModel()
)
