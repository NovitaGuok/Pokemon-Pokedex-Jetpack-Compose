package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.Other

data class OtherDto(

    @SerializedName("dream_world")
    val dreamWorld: IconsDto = IconsDto(),

    @SerializedName("home")
    val home: XYDto = XYDto(),

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDto = OfficialArtworkDto()
)

fun OtherDto.toModel() = Other(
    this.dreamWorld.toModel(),
    this.home.toModel(),
    this.officialArtwork.toModel()
)
