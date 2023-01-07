package com.compose.pokemonapp.novita.domain.common.model

data class Stat(
    val baseStat: Int = 0,
    val effort: Int = 0,
    val stat: Pokemon = Pokemon()
)
