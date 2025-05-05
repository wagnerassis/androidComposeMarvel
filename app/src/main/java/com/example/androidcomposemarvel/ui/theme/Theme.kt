package com.example.androidcomposemarvel.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color

// Marvel brand colors
private val MarvelRed       = Color(0xFFED1D24)
private val MarvelRedDark   = Color(0xFFC20C0E)
private val MarvelBlack     = Color(0xFF000000)
private val MarvelWhite     = Color(0xFFFFFFFF)
private val MarvelErrorRed  = Color(0xFFB00020) // ou outro tom que preferir

// Paleta light
private val LightColors = lightColors(
    primary         = MarvelRed,
    primaryVariant  = MarvelRedDark,
    secondary       = MarvelBlack,
    background      = MarvelWhite,
    surface         = MarvelWhite,
    error           = MarvelErrorRed,
    onPrimary       = MarvelWhite,
    onSecondary     = MarvelWhite,
    onBackground    = MarvelBlack,
    onSurface       = MarvelBlack,
    onError         = MarvelWhite,
)

// Paleta dark
private val DarkColors = darkColors(
    primary         = MarvelRed,
    primaryVariant  = MarvelRedDark,
    secondary       = MarvelWhite,
    background      = MarvelBlack,
    surface         = MarvelBlack,
    error           = MarvelErrorRed,
    onPrimary       = MarvelBlack,
    onSecondary     = MarvelBlack,
    onBackground    = MarvelWhite,
    onSurface       = MarvelWhite,
    onError         = MarvelBlack,
)

@Composable
fun AndroidComposeMarvelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colors     = colors,
        typography = Typography(),
        shapes     = Shapes(),
        content    = content
    )
}

