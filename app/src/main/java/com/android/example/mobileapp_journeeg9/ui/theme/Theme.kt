package com.android.example.mobileapp_journeeg9.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// === 🎨 MOCKUP COLORS ===
val Purple = color(0xFF3C2A87)
val DarkText = color(0xFF002B36)
val Gray = color(0xFF888888)
val White = color(0xFFFFFFFF)
val BackgroundLight = color(0xFFFFFFFF)
val BackgroundDark = color(0xFF121212)

// === 🧱 LIGHT THEME ===
private val LightColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = White,
    background = BackgroundLight,
    onBackground = DarkText,
    surface = White,
    onSurface = DarkText
)

// === 🌚 DARK THEME ===
private val DarkColorScheme = darkColorScheme(
    primary = Purple,
    onPrimary = White,
    background = BackgroundDark,
    onBackground = White,
    surface = BackgroundDark,
    onSurface = White
)

@Composable
fun MobileApp_JourneeG9Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
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

    // Apply status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // You can define custom fonts in Typography.kt
        content = content
    )
}
