package com.phincon.pokemonapp.novita.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.phincon.pokemonapp.novita.presentation.detail.screen.DetailScreen
import com.phincon.pokemonapp.novita.presentation.home.screen.HomeScreen
import com.phincon.pokemonapp.novita.presentation.my_pokemon.screen.MyPokemonScreen
import com.phincon.pokemonapp.novita.util.ScreenRoute

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = ScreenRoute.Home.route) {
        composable(route = ScreenRoute.Home.route) {
            HomeScreen(navHostController)
        }
        composable(
            route = ScreenRoute.Detail.route + "/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            val name = it.arguments?.getString("name")
            DetailScreen(navHostController, name.orEmpty())
        }
        composable(
            route = ScreenRoute.MyPokemon.route,
        ) {
            MyPokemonScreen(navHostController)
        }
    }
}
