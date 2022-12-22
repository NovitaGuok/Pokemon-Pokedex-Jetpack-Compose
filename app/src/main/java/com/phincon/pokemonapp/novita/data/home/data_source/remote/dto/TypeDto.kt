package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.model.Type

data class TypeDto(

    @SerializedName("slot")
    val slot: Int = 0,

    @SerializedName("type")
    val type: PokemonDto = PokemonDto()
)

fun TypeDto.toModel() = Type(
    this.slot,
    this.type.toModel()
)
