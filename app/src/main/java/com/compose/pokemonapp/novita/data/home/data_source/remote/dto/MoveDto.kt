package com.compose.pokemonapp.novita.data.home.data_source.remote.dto

import com.compose.pokemonapp.novita.domain.common.model.Move
import com.google.gson.annotations.SerializedName

data class MoveDto(

    @SerializedName("move")
    val move: PokemonDto = PokemonDto(),

    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailDto> = listOf()
)

fun MoveDto.toModel() = Move(
    this.move.toModel(),
    this.versionGroupDetails.map { it.toModel() }
)
