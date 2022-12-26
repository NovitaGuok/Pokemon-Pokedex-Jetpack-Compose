package com.phincon.pokemonapp.novita.presentation.common.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textRegular14
import com.phincon.pokemonapp.novita.util.gifLoader

@Composable
fun ItemEmpty(modifier: Modifier) {
    val ctx = LocalContext.current
    val imageLoader = gifLoader(ctx)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(ctx).data(R.drawable.ic_pokeball).build(),
                imageLoader = imageLoader
            ),
            contentDescription = stringResource(R.string.img_desc_pokeball_animation),
        )
        Text(text = stringResource(R.string.all_no_data), style = textRegular14)
    }
}

@Composable
@Preview(showBackground = true)
fun ItemEmptyPreview() {
    PhinConTechnicalTestTheme {
        ItemError(Modifier.fillMaxSize()) {}
    }
}
