package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.Pokemon

data class PokemonDto(

    @SerializedName("name")
    val name: String = "",

    @SerializedName("url")
    val url: String = ""
)

fun PokemonDto.toModel() = Pokemon(
    this.name,
    this.url
)
