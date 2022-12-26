package com.phincon.pokemonapp.novita.util

import android.graphics.Color
import java.util.Random

object RandomGenerator {
    fun randomColorGenerator(): Int {
        val rand = Random()
        return Color.argb(
            50,
            rand.nextInt(256),
            rand.nextInt(256),
            rand.nextInt(256)
        )
    }

    fun randomProbabilityGenerator(): Boolean {
        val random = Random()
        return random.nextBoolean()
    }
}
