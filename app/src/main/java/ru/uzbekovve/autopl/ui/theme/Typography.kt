package ru.uzbekovve.autopl.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.uzbekovve.autopl.R

val fontsManrope = FontFamily(
    Font(R.font.manrope)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 48.sp,
        fontWeight = FontWeight.W700,
        color = Color.Black
    ),
    h2 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        color = Color.Black
    ),
    h3 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        color = Color.Black
    ),
    h4 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        color = Color.Black
    ),
    button = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 18.sp,
        fontWeight = FontWeight.W700,
        color = Color.Black
    ),
    body1 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        color = Color.Black
    ),
    subtitle1 = TextStyle(
        fontFamily = fontsManrope,
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        color = Grey
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