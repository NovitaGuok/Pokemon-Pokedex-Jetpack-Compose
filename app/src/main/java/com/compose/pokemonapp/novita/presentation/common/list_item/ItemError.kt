package com.compose.pokemonapp.novita.presentation.common.list_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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

@Composable
fun ItemError(modifier: Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onClick() },
            modifier = Modifier.size(dimensionResource(id = R.dimen.size_52)),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_refresh),
                contentDescription = stringResource(R.string.all_desc_refresh)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemErrorPreview() {
    ComposePokemonAppTheme {
        ItemError(Modifier.fillMaxSize()) {}
    }
}
