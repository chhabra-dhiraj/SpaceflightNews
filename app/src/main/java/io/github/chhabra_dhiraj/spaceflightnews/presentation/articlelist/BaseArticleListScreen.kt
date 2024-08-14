package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import io.github.chhabra_dhiraj.spaceflightnews.ArticleDetail
import io.github.chhabra_dhiraj.spaceflightnews.NavigationEvent
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.rememberFlowWithLifecycle

@Composable
fun BaseArticleListScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<ArticleListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val navigationEvent = rememberFlowWithLifecycle(viewModel.navigationEvent)

    LaunchedEffect(navigationEvent) {
        navigationEvent.collect { event ->
            when (event) {
                is NavigationEvent.NavigateToArticle -> {
                    navController.navigate(
                        ArticleDetail(
                            articleId = event.articleId
                        )
                    )
                }

                else -> Unit
            }
        }
    }

    ArticleListScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}