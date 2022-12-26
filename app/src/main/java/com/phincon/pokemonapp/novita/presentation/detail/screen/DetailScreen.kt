package com.phincon.pokemonapp.novita.presentation.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phincon.pokemonapp.novita.R
import com.phincon.pokemonapp.novita.domain.common.model.MyPokemon
import com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.phincon.pokemonapp.novita.presentation.common.progress_indicator.CircularProgressBar
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.PhinConTechnicalTestTheme
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textBold20
import com.phincon.pokemonapp.novita.presentation.common.ui.theme.textRegular14
import com.phincon.pokemonapp.novita.presentation.detail.component.animation.DetailAnimation
import com.phincon.pokemonapp.novita.presentation.detail.component.chart.HorizontalBar
import com.phincon.pokemonapp.novita.presentation.detail.component.header.DetailHeader
import com.phincon.pokemonapp.novita.presentation.detail.component.list_item.ItemPokemonMove
import com.phincon.pokemonapp.novita.presentation.detail.viewmodel.DetailViewModel
import com.phincon.pokemonapp.novita.util.Constant.ATK
import com.phincon.pokemonapp.novita.util.Constant.DEF
import com.phincon.pokemonapp.novita.util.Constant.SPEED
import com.phincon.pokemonapp.novita.util.Constant.SP_ATK
import com.phincon.pokemonapp.novita.util.Constant.SP_DEF
import com.phincon.pokemonapp.novita.util.Constant.TOTAL_HP
import com.phincon.pokemonapp.novita.util.Extension.capitalizeWords
import com.phincon.pokemonapp.novita.util.RandomGenerator
import com.phincon.pokemonapp.novita.util.RandomGenerator.randomProbabilityGenerator
import com.phincon.pokemonapp.novita.util.Resource
import com.phincon.pokemonapp.novita.util.ScreenRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

const val REGULAR_SPACER_HEIGHT = 8
const val SECTION_SPACER_HEIGHT = 20

@Composable
fun DetailScreen(
    navController: NavController,
    name: String,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    detailViewModel.getPokemonByName(name)
    val pokemonState = detailViewModel.pokemonState.collectAsState().value
    val pokemonData = pokemonState.data
    val frontSprites =
        pokemonData?.sprites?.versions?.generationV?.blackWhite?.animated?.front_default
    val backSprites =
        pokemonData?.sprites?.versions?.generationV?.blackWhite?.animated?.back_default
    val statDesc = listOf(TOTAL_HP, ATK, DEF, SP_ATK, SP_DEF, SPEED)
    val scrollState = rememberScrollState()
    val bgColor = RandomGenerator.randomColorGenerator()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var isCaught: Boolean

    Scaffold(scaffoldState = scaffoldState) {
        when (pokemonState) {
            is Resource.Loading -> {
                CircularProgressBar(modifier = Modifier.fillMaxSize())
            }
            is Resource.Success -> {
                detailViewModel.cancelJob()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(bgColor))
                        .verticalScroll(scrollState),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(2f)
                    ) {
                        DetailHeader(
                            modifier = Modifier.fillMaxWidth(),
                            pokemon = pokemonData ?: SpecificPokemon()
                        ) {
                            scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                            isCaught = randomProbabilityGenerator()
                            if (isCaught) {
                                detailViewModel.catchPokemon(
                                    MyPokemon(
                                        name = pokemonData?.name.orEmpty(),
                                        imgUrl = frontSprites.orEmpty(),
                                    )
                                )
                                coroutineScope.launch {
                                    val snackbarResult =
                                        scaffoldState.snackbarHostState.showSnackbar(
                                            message = "Gotcha!",
                                            actionLabel = "See my Pokemon",
                                            duration = SnackbarDuration.Short
                                        )
                                    when (snackbarResult) {
                                        SnackbarResult.ActionPerformed -> {
                                            navController.navigate(ScreenRoute.MyPokemon.route)
                                        }
                                        else -> {}
                                    }
                                }
                            } else {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        message = "Oopsie, it runs away",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(2f / 1f)
                                .padding(horizontal = dimensionResource(R.dimen.size_16)),
                        ) {
                            DetailAnimation(
                                modifier = Modifier.weight(.3f),
                                sprites = frontSprites.orEmpty(),
                            )
                            DetailAnimation(
                                modifier = Modifier.weight(.3f),
                                sprites = backSprites.orEmpty(),
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = dimensionResource(R.dimen.size_264))
                            .clip(
                                RoundedCornerShape(
                                    topStartPercent = 12,
                                    topEndPercent = 12
                                )
                            )
                            .background(Color.White)
                    ) {
                        Column {
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        top = dimensionResource(R.dimen.size_40)
                                    ),
                                text = stringResource(R.string.txt_detail_title_stats),
                                style = textBold20
                            )
                            Column(
                                modifier = Modifier
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        end = dimensionResource(R.dimen.size_16),
                                        top = REGULAR_SPACER_HEIGHT.dp,
                                    )
                            ) {
                                repeat(pokemonData?.stats?.size ?: 0) {
                                    val stat = pokemonData?.stats?.get(it)
                                    HorizontalBar(
                                        statDesc = statDesc[it],
                                        statValue = stat?.baseStat?.toFloat() ?: 0f
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        end = dimensionResource(R.dimen.size_16),
                                        top = SECTION_SPACER_HEIGHT.dp,
                                    ),
                                text = stringResource(
                                    R.string.txt_detail_title_abilities
                                ),
                                style = textBold20
                            )
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        end = dimensionResource(R.dimen.size_16),
                                        top = REGULAR_SPACER_HEIGHT.dp,
                                    ),
                                text = pokemonData?.abilities?.joinToString(separator = ", ") {
                                    it.ability.name.capitalizeWords()
                                }.orEmpty(),
                                style = textRegular14
                            )
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        end = dimensionResource(R.dimen.size_16),
                                        top = SECTION_SPACER_HEIGHT.dp,
                                    ),
                                text = stringResource(R.string.txt_detail_title_moves),
                                style = textBold20
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(
                                        start = dimensionResource(R.dimen.size_16),
                                        end = dimensionResource(R.dimen.size_16),
                                        top = REGULAR_SPACER_HEIGHT.dp,
                                        bottom = dimensionResource(R.dimen.size_16),
                                    ),
                                verticalArrangement = Arrangement.spacedBy(
                                    dimensionResource(R.dimen.size_4)
                                ),
                            ) {
                                repeat(pokemonData?.moves?.size ?: 0) {
                                    val moveName = pokemonData?.moves?.get(it)?.move?.name
                                    ItemPokemonMove(
                                        moveName = moveName.orEmpty()
                                    ) {
                                        /** TODO */
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else -> {}
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    PhinConTechnicalTestTheme {
        DetailScreen(rememberNavController(), "bulbasaur")
    }
}
