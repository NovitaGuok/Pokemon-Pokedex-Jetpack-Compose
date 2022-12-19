package com.phincon.pokemonapp.novita.presentation.home.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
import com.phincon.pokemonapp.novita.domain.model.Sprites
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textBold20
import com.phincon.pokemonapp.novita.util.Extension.capitalize

@Composable
fun ItemPokemon(data: SpecificPokemon) {
    Card(modifier = Modifier.aspectRatio(1f / 1f)) {
        ConstraintLayout {
            val (img, name) = createRefs()
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .constrainAs(img) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                painter = rememberAsyncImagePainter(
                    data.sprites.versions.generationV.blackWhite.animated.front_default
                ),
                contentDescription = stringResource(R.string.img_desc_pokemon_animation),
            )
            Text(
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(img.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = capitalize(data.name),
                style = textBold20
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemPokemonPreview() {
    PhinConTechnicalTestTheme {
        ItemPokemon(
            SpecificPokemon(
                name = "bulbasaur",
                sprites = Sprites(frontDefault = "https://rb.gy/cq38ca")
            )
        )
    }
}
