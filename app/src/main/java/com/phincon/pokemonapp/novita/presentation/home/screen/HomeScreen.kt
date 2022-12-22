package com.phincon.pokemonapp.novita.presentation.home.screen

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.domain.model.LazyGridData
import com.phincon.pokemonapp.novita.domain.model.LoadingDataModel
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
import com.phincon.pokemonapp.novita.presentation.common.list_item.ItemError
import com.phincon.pokemonapp.novita.presentation.common.progress_indicator.CircularProgressBar
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.home.list_item.ItemPokemon
import com.phincon.pokemonapp.novita.presentation.home.viewmodel.HomeViewModel
import com.phincon.pokemonapp.novita.util.OnBottomReached
import com.phincon.pokemonapp.novita.util.Resource

const val GRID_COLUMN_SIZE = 2

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val pokemonListState = homeViewModel.pokemonListState.collectAsState().value
    val lazyGridState = rememberLazyGridState()

    Scaffold(
        topBar = {},
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
                        )
                    ) {
                        items(pokemonListState.data as List<LazyGridData>, span = { item ->
                            val span = if (item is LoadingDataModel) {
                                GRID_COLUMN_SIZE
                            } else {
                                1
                            }
                            GridItemSpan(span)
                        }) { item ->
                            when (item) {
                                is LoadingDataModel -> {
                                    CircularProgressBar(modifier = Modifier.height(64.dp))
                                }
                                is SpecificPokemon -> {
                                    ItemPokemon(data = item)
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
