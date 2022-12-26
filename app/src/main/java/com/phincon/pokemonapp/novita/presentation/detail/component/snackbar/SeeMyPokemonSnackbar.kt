package com.phincon.pokemonapp.novita.presentation.detail.component.snackbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme

@Composable
fun SeeMyPokemonSnackbar(snackbarVisibleState: Boolean, onClick: () -> Unit) {
    Column {
        if (snackbarVisibleState) {
            Snackbar(
                action = {
                    Button(onClick = { onClick() }) {
                        Text("See My Pokemon")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "This is a snackbar!") }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SeeMyPokemonSnackbarPreview() {
    PhinConTechnicalTestTheme {
        SeeMyPokemonSnackbar(true) {}
    }
}
