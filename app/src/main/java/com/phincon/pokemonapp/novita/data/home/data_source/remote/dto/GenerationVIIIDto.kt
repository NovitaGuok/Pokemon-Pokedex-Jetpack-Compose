package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.GenerationVIII

data class GenerationVIIIDto(
    @SerializedName("icons")
    val icons: IconsDto = IconsDto()
)

fun GenerationVIIIDto.toModel() = GenerationVIII(
    this.icons.toModel()
)
