package com.compose.pokemonapp.novita.presentation.detail.component.list_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.pokemonapp.novita.R
import com.compose.pokemonapp.novita.presentation.common.ui.theme.ComposePokemonAppTheme
import com.compose.pokemonapp.novita.presentation.common.ui.theme.textRegular14
import com.compose.pokemonapp.novita.util.Extension.capitalizeWords

@Composable
fun ItemPokemonMove(moveName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.clickable { onClick() },
        shape = RoundedCornerShape(size = dimensionResource(R.dimen.size_8)),
        border = BorderStroke(dimensionResource(R.dimen.size_1), Color.LightGray),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.size_8))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = moveName.replace('-', ' ').capitalizeWords(), style = textRegular14)
            Icon(
                modifier = Modifier.size(dimensionResource(R.dimen.size_16)),
                painter = painterResource(R.drawable.ic_baseline_open_in_new),
                contentDescription = stringResource(R.string.txt_desc_open_in_new)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemPokemonMovePreview() {
    ComposePokemonAppTheme {
        ItemPokemonMove("Cut") {}
    }
}
