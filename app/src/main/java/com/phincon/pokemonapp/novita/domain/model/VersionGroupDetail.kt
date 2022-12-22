package com.phincon.pokemonapp.novita.domain.model

data class VersionGroupDetail(
    val levelLearnedAt: Int = 0,
    val moveLearnMethod: Pokemon = Pokemon(),
    val versionGroup: Pokemon = Pokemon()
)
