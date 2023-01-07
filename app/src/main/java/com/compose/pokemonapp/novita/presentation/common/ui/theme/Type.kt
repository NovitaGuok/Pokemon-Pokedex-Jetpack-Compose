package com.compose.pokemonapp.novita.presentation.common.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.pokemonapp.novita.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val robotoFamily = FontFamily(
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_black, FontWeight.Bold),
    Font(R.font.roboto_black_italic, FontWeight.Bold, FontStyle.Italic),
)

val textRegular10 = TextStyle(
    fontSize = 10.sp,
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Normal
)

val textRegular14 = TextStyle(
    fontSize = 14.sp,
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Normal
)

val textBold16 = TextStyle(
    fontSize = 16.sp,
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Bold
)

val textBold20 = TextStyle(
    fontSize = 20.sp,
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Bold
)

val textBold32 = TextStyle(
    fontSize = 32.sp,
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Bold
)
