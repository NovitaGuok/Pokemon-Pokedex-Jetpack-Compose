package com.phincon.pokemonapp.novita.util

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("home_screen")
    object Detail : ScreenRoute("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
