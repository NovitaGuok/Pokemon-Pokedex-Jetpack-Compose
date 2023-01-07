package com.compose.pokemonapp.novita.presentation.my_pokemon.component.app_bar

import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.compose.pokemonapp.novita.R

@Composable
fun MyPokemonTopAppBar(onClick: () -> Unit) {
    TopAppBar(
        elevation = AppBarDefaults.TopAppBarElevation,
        title = { Text(stringResource(R.string.txt_my_pokemon)) },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }
    )
}
