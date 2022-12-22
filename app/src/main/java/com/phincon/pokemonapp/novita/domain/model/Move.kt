package com.phincon.pokemonapp.novita.domain.model

data class Move(
    val move: Pokemon = Pokemon(),
    val versionGroupDetails: List<VersionGroupDetail> = listOf()
)
