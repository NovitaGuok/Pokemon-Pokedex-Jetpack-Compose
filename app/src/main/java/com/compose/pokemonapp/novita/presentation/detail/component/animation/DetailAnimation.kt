package com.compose.pokemonapp.novita.presentation.detail.component.animation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.util.gifLoader

@Composable
fun DetailAnimation(modifier: Modifier, sprites: String) {
    val ctx = LocalContext.current
    val imageLoader = gifLoader(ctx)

    Image(
        modifier = modifier.aspectRatio(1f / 1f),
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(ctx).data(sprites).build(),
            imageLoader = imageLoader
        ),
        contentDescription = stringResource(
            R.string.img_desc_pokeball_animation
        ),
        contentScale = ContentScale.Fit
    )
}
