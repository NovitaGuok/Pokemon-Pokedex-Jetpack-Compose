package com.phincon.pokemonapp.novita.domain.model

data class Ability(
    val ability: Pokemon = Pokemon(),
    val isHidden: Boolean = false,
    val slot: Int = 0
)
