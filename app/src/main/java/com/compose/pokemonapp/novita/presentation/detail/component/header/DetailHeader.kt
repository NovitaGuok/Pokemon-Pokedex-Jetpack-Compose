package com.compose.pokemonapp.novita.presentation.detail.component.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.compose.pokemonapp.novita.presentation.common.ui.theme.ComposePokemonAppTheme
import com.compose.pokemonapp.novita.presentation.common.ui.theme.textBold16
import com.compose.pokemonapp.novita.presentation.common.ui.theme.textBold32
import com.compose.pokemonapp.novita.presentation.common.ui.theme.textRegular14
import com.compose.pokemonapp.novita.util.Extension.capitalizeWords
import com.compose.pokemonapp.novita.util.gifLoader

@Composable
fun DetailHeader(modifier: Modifier, pokemon: SpecificPokemon, onClick: () -> Unit) {

    val ctx = LocalContext.current
    val imageLoader = gifLoader(ctx)

    ConstraintLayout(
        modifier = modifier.padding(dimensionResource(id = R.dimen.size_16))
    ) {
        val (name, weight, height, btnCatch) = createRefs()

        Text(
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = pokemon.name.capitalizeWords(), style = textBold32
        )
        Text(
            modifier = Modifier.constrainAs(weight) {
                top.linkTo(name.bottom)
                start.linkTo(parent.start)
            },
            text = stringResource(id = R.string.txt_detail_weight, pokemon.weight),
            style = textRegular14,
        )
        Text(
            modifier = Modifier.constrainAs(height) {
                top.linkTo(weight.bottom)
                start.linkTo(parent.start)
            },
            text = stringResource(id = R.string.txt_detail_height, pokemon.height),
            style = textRegular14
        )
        Button(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.size_40))
                .constrainAs(btnCatch) {
                    top.linkTo(weight.top)
                    end.linkTo(parent.end)
                },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { onClick() }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(ctx).data(R.drawable.ic_pokeball).build(),
                        imageLoader = imageLoader
                    ),
                    contentDescription = stringResource(R.string.img_desc_pokeball_animation),
                )
                Text(
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.size_2)),
                    text = stringResource(R.string.txt_detail_catch),
                    style = textBold16
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailHeaderPreview() {
    ComposePokemonAppTheme {
        DetailHeader(Modifier, SpecificPokemon(name = "bulbasaur", weight = 50, height = 50)) {}
    }
}
