package com.example.journee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.journee.ui.navigation.AppNavigation
import com.example.journee.ui.theme.JourneeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JourneeTheme {
                AppNavigation()
            }
        }
    }
}
