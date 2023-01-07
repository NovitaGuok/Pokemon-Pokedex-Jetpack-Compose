package com.compose.pokemonapp.novita.domain.common.model

data class Ability(
    val ability: Pokemon = Pokemon(),
    val isHidden: Boolean = false,
    val slot: Int = 0
)
