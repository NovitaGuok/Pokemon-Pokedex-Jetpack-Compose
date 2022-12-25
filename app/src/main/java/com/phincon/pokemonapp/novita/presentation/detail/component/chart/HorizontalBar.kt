package com.phincon.pokemonapp.novita.presentation.detail.component.chart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.Orange
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textRegular10
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textRegular14

@Composable
fun HorizontalBar(statDesc: String, statValue: Float) {

    val statPercentage = statValue * .8f / 100f

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.size_20))
    ) {
        val (desc, bg, valueBar) = createRefs()

        Text(
            modifier = Modifier
                .fillMaxWidth(.2f)
                .constrainAs(desc) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            text = statDesc, style = textRegular14
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .height(dimensionResource(R.dimen.size_12))
                .clip(RoundedCornerShape(50))
                .background(Color.Gray)
                .constrainAs(bg) {
                    end.linkTo(parent.end)
                    top.linkTo(desc.top)
                    bottom.linkTo(desc.bottom)
                }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(statPercentage)
                .height(dimensionResource(R.dimen.size_12))
                .clip(RoundedCornerShape(50))
                .background(color = Orange)
                .padding(horizontal = dimensionResource(R.dimen.size_4))
                .constrainAs(valueBar) {
                    start.linkTo(bg.start)
                    top.linkTo(bg.top)
                    bottom.linkTo(bg.bottom)
                },
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.txt_detail_stat_value, statValue),
                style = textRegular10,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailStatsPreview() {
    PhinConTechnicalTestTheme {
        Column {
            HorizontalBar("HP", 49f)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_2)))
            HorizontalBar("Atk", 60f)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_2)))
            HorizontalBar("Speed", 29f)
        }
    }
}
