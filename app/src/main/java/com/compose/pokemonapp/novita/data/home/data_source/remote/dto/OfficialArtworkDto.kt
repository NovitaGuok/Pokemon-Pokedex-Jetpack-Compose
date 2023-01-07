package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.OfficialArtwork
import com.google.gson.annotations.SerializedName

data class OfficialArtworkDto(
    @SerializedName("front_default")
    val frontDefault: String = ""
)

fun OfficialArtworkDto.toModel() =
    OfficialArtwork(
        this.frontDefault
    )
