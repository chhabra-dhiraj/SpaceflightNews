package io.github.chhabra_dhiraj.spaceflightnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceflightNewsTheme {

            }
        }
    }
}