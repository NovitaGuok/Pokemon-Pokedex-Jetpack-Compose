package com.phincon.pokemonapp.novita.data.home.data_source.remote.dto

import com.google.gson.annotations.SerializedName
import com.phincon.pokemonapp.novita.domain.common.model.Ability

data class AbilityDto(

    @SerializedName("ability")
    val ability: PokemonDto = PokemonDto(),

    @SerializedName("is_hidden")
    val isHidden: Boolean = false,

    @SerializedName("slot")
    val slot: Int = 0
)

fun AbilityDto.toModel() = Ability(
    this.ability.toModel(),
    this.isHidden,
    this.slot
)
