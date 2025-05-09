package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFF8BBD0),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFCE4EC),
    onPrimaryContainer = Color(0xFF880E4F),

    secondary = Color(0xFFF48FB1),
    onSecondary = Color.White,
    background = Color(0xFFFFF1F5),
    onBackground = Color.Black,
    surface = Color(0xFFFFF1F5),
    onSurface = Color.Black,
    outline = Color(0xFFF8BBD0)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFF48FB1),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF880E4F),
    onPrimaryContainer = Color.White,

    secondary = Color(0xFFD81B60),
    onSecondary = Color.White,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    outline = Color(0xFFF06292)
)

@Composable
fun Packagecomghinafadiyahhr6070623000001assessment2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}