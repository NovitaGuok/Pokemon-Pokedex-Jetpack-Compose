package com.compose.pokemonapp.novita.domain.common.model

import com.google.gson.annotations.SerializedName

data class GenerationII(

    @SerializedName("crystal")
    val crystal: Crystal = Crystal(),

    @SerializedName("gold")
    val gold: SilverGold = SilverGold(),

    @SerializedName("silver")
    val silver: SilverGold = SilverGold()
)
