package io.github.chhabra_dhiraj.spaceflightnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListScreen
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceflightNewsTheme {
                val viewModel = viewModel<ArticleListViewModel>()
                val state by viewModel.state.collectAsState()
                ArticleListScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}