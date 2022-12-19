package com.phincon.pokemonapp.novita.presentation.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.presentation.common.progress_indicator.CircularProgressIndicator
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.home.list_item.ItemPokemon
import com.phincon.pokemonapp.novita.presentation.home.viewmodel.HomeViewModel
import com.phincon.pokemonapp.novita.util.Resource
import timber.log.Timber

const val GRID_COLUMN_SIZE = 2

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val pokemonListState = homeViewModel.pokemonListState.collectAsState().value

    Scaffold(
        topBar = {},
        content = {
            when (pokemonListState) {
                is Resource.Loading -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(modifier = Modifier.fillMaxSize())

                    }
                }
                is Resource.Success -> {
                    LazyVerticalGrid(columns = GridCells.Fixed(GRID_COLUMN_SIZE)) {
//                        items(pokemonListState.data as List<Pokemon>) { item ->
//                            ItemPokemon(data = item)
//                        }
                    }
                    Timber.d("homescreen ${pokemonListState.data}")
                }
                else -> {}
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PhinConTechnicalTestTheme {
        HomeScreen()
    }
}
