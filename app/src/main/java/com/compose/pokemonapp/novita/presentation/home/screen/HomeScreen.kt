package com.compose.pokemonapp.novita.presentation.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.domain.common.model.LazyGridData
import com.compose.pokemonapp.novita.domain.common.model.LoadingDataModel
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.compose.pokemonapp.novita.presentation.common.list_item.ItemError
import com.compose.pokemonapp.novita.presentation.common.progress_indicator.CircularProgressBar
import com.compose.pokemonapp.novita.presentation.common.ui.theme.ComposePokemonAppTheme
import com.compose.pokemonapp.novita.presentation.home.component.app_bar.HomeTopAppBar
import com.compose.pokemonapp.novita.presentation.home.component.list_item.ItemPokemon
import com.compose.pokemonapp.novita.presentation.home.viewmodel.HomeViewModel
import com.compose.pokemonapp.novita.util.OnBottomReached
import com.compose.pokemonapp.novita.util.Resource
import com.compose.pokemonapp.novita.util.ScreenRoute

const val GRID_COLUMN_SIZE = 2

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val pokemonListState = homeViewModel.pokemonListState.collectAsState().value
    val lazyGridState = rememberLazyGridState()

    Scaffold(
        topBar = {
            HomeTopAppBar {
                navController.navigate(ScreenRoute.MyPokemon.route)
            }
        },
        content = {
            when (pokemonListState) {
                is Resource.Loading -> {
                    CircularProgressBar(modifier = Modifier.fillMaxSize())
                }
                is Resource.Success -> {
                    LazyVerticalGrid(
                        state = lazyGridState,
                        modifier = Modifier.padding(dimensionResource(R.dimen.size_16)),
                        columns = GridCells.Fixed(GRID_COLUMN_SIZE),
                        verticalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.size_8)
                        ),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.size_8)
                        ),
                    ) {
                        items(
                            items = pokemonListState.data as List<LazyGridData>,
                            span = { item ->
                                val span = if (item is LoadingDataModel) {
                                    GRID_COLUMN_SIZE
                                } else {
                                    1
                                }
                                GridItemSpan(span)
                            },
                            key = { item -> item.id }
                        ) { item ->
                            when (item) {
                                is LoadingDataModel -> {
                                    CircularProgressBar(
                                        modifier = Modifier.height(
                                            dimensionResource(
                                                id = R.dimen.size_64
                                            )
                                        )
                                    )
                                }
                                is SpecificPokemon -> {
                                    ItemPokemon(data = item) {
                                        navController.navigate(
                                            ScreenRoute.Detail.withArgs(item.name)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    lazyGridState.OnBottomReached(buffer = 2) {
                        homeViewModel.loadNext()
                    }
                }
                is Resource.Error -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ItemError(modifier = Modifier.fillMaxSize()) {
                            /** TODO */
                        }
                    }
                }
                else -> {
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposePokemonAppTheme {
        HomeScreen(rememberNavController())
    }
}
