package com.compose.pokemonapp.novita.domain.common.model

data class VersionGroupDetail(
    val levelLearnedAt: Int = 0,
    val moveLearnMethod: Pokemon = Pokemon(),
    val versionGroup: Pokemon = Pokemon()
)
