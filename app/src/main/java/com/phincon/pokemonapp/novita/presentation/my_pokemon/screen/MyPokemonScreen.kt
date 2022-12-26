package com.phincon.pokemonapp.novita.presentation.my_pokemon.screen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.domain.common.model.LazyGridData
import com.phincon.pokemonapp.novita.domain.common.model.LoadingDataModel
import com.phincon.pokemonapp.novita.domain.common.model.MyPokemon
import com.phincon.pokemonapp.novita.presentation.common.list_item.ItemEmpty
import com.phincon.pokemonapp.novita.presentation.common.progress_indicator.CircularProgressBar
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.my_pokemon.component.app_bar.MyPokemonTopAppBar
import com.phincon.pokemonapp.novita.presentation.my_pokemon.component.list_item.ItemMyPokemon
import com.phincon.pokemonapp.novita.presentation.my_pokemon.viewmodel.MyPokemonViewModel
import com.phincon.pokemonapp.novita.util.Resource
import com.phincon.pokemonapp.novita.util.ScreenRoute

const val GRID_COLUMN_SIZE = 2

@Composable
fun MyPokemonScreen(
    navController: NavController,
    myPokemonViewModel: MyPokemonViewModel = hiltViewModel()
) {
    val myPokemonListState = myPokemonViewModel.myPokemonListState.collectAsState().value
    val myPokemonList = myPokemonListState.data
    val lazyGridState = rememberLazyGridState()

    Scaffold(
        topBar = {
            MyPokemonTopAppBar {
                navController.navigateUp()
            }
        },
        content = {
            when (myPokemonListState) {
                is Resource.Loading -> {
                    CircularProgressBar(modifier = Modifier.fillMaxSize())
                }
                is Resource.Empty -> {
                    ItemEmpty(modifier = Modifier.fillMaxSize())
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
                        items(
                            items = myPokemonList as List<LazyGridData>,
                            span = { item ->
                                val span = if (item is LoadingDataModel) {
                                    GRID_COLUMN_SIZE
                                } else {
                                    1
                                }
                                GridItemSpan(span)
                            },
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
                                is MyPokemon -> {
                                    ItemMyPokemon(
                                        data = MyPokemon(
                                            name = item.name,
                                            imgUrl = item.imgUrl,
                                            owned = item.owned
                                        ),
                                        onClick = {
                                            navController.navigate(
                                                ScreenRoute.Detail.withArgs(item.name)
                                            )
                                        },
                                        onDelete = { myPokemonViewModel.deletePokemon(item.name) }
                                    )
                                }
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun MyPokemonScreenPreview() {
    PhinConTechnicalTestTheme {
        MyPokemonScreen(rememberNavController())
    }
}
