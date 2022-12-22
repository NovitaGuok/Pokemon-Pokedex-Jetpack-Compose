package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.GameIndice

data class GameIndiceDto(

    @SerializedName("game_index")
    val gameIndex: Int = 0,

    @SerializedName("version")
    val version: PokemonDto = PokemonDto()
)

fun GameIndiceDto.toModel() = GameIndice(
    this.gameIndex,
    this.version.toModel()
)
