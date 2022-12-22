package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.OfficialArtwork

data class OfficialArtworkDto(
    @SerializedName("front_default")
    val frontDefault: String = ""
)

fun OfficialArtworkDto.toModel() = OfficialArtwork(
    this.frontDefault
)
