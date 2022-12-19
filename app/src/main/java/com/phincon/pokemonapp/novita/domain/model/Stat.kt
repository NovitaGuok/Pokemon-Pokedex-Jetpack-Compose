package com.phincon.pokemonapp.novita.domain.model

data class Stat(
    val baseStat: Int = 0,
    val effort: Int = 0,
    val stat: Pokemon = Pokemon()
)
