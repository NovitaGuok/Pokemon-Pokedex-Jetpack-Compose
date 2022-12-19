package com.phincon.pokemonapp.novita.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phincon.pokemonapp.novita.presentation.home.screen.HomeScreen
import com.phincon.pokemonapp.novita.util.ScreenRoute

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = ScreenRoute.Home.route) {
        composable(route = ScreenRoute.Home.route) {
            HomeScreen()
        }
    }
}
