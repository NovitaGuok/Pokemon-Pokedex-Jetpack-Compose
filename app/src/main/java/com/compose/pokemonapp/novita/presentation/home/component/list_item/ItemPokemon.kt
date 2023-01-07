package com.compose.pokemonapp.novita.presentation.home.component.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.compose.pokemonapp.novita.domain.common.model.Sprites
import com.compose.pokemonapp.novita.presentation.common.ui.theme.ComposePokemonAppTheme
import com.compose.pokemonapp.novita.presentation.common.ui.theme.textBold20
import com.compose.pokemonapp.novita.util.Extension.capitalizeWords
import com.compose.pokemonapp.novita.util.RandomGenerator.randomColorGenerator
import com.compose.pokemonapp.novita.util.gifLoader

@Composable
fun ItemPokemon(data: SpecificPokemon, onClick: () -> Unit) {

    val ctx = LocalContext.current
    val imageLoader = gifLoader(ctx)
    val color = randomColorGenerator()

    Card(
        modifier = Modifier
            .aspectRatio(1f / 1f)
            .clickable { onClick() },
        backgroundColor = Color(color)
    ) {
        ConstraintLayout {
            val (img, name) = createRefs()
            createVerticalChain(img, name, chainStyle = ChainStyle.Packed)

            Image(
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .aspectRatio(1f / 1f)
                    .constrainAs(img) {
                        top.linkTo(parent.top)
                        bottom.linkTo(name.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(ctx).data(
                        data.sprites.versions.generationV.blackWhite.animated.front_default
                    ).apply(block = {
                        size(Size.ORIGINAL)
                    }).build(),
                    imageLoader = imageLoader
                ),
                contentDescription = stringResource(R.string.img_desc_pokemon_animation),
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(img.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = data.name.capitalizeWords(),
                style = textBold20
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemPokemonPreview() {
    ComposePokemonAppTheme {
        ItemPokemon(
            SpecificPokemon(
                name = "bulbasaur",
                sprites = Sprites(frontDefault = "https://rb.gy/cq38ca")
            )
        ) {}
    }
}
