package com.phincon.pokemonapp.novita.util

import java.util.Locale

object Extension {
    fun capitalize(str: String): String {
        return str.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
        }
    }
}
