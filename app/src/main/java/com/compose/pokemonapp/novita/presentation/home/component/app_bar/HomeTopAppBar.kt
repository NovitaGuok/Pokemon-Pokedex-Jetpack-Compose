package com.compose.pokemonapp.novita.presentation.home.component.app_bar

import androidx.compose.foundation.Image
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.util.gifLoader

@Composable
fun HomeTopAppBar(onClick: () -> Unit) {
    val ctx = LocalContext.current
    val imageLoader = gifLoader(ctx)

    TopAppBar(
        elevation = AppBarDefaults.TopAppBarElevation,
        title = { Text(stringResource(R.string.txt_home)) },
        backgroundColor = MaterialTheme.colors.primarySurface,
        actions = {
            IconButton(onClick = { onClick() }) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(ctx).data(R.drawable.ic_pokeball).apply(block = {
                            size(100)
                        }).build(),
                        imageLoader = imageLoader
                    ),
                    contentDescription = stringResource(R.string.img_desc_pokeball_animation),
                )
            }
        }
    )
}
