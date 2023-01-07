package com.compose.pokemonapp.novita.domain.common.model

data class Move(
    val move: Pokemon = Pokemon(),
    val versionGroupDetails: List<VersionGroupDetail> = listOf()
)
