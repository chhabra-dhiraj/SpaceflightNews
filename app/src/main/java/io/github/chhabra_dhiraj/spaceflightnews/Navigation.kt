package io.github.chhabra_dhiraj.spaceflightnews

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailEvent
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailScreen
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListScreen
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util.rememberFlowWithLifecycle

@Immutable
sealed class NavigationEvent {
    data class NavigateToArticle(val articleId: Int) : NavigationEvent()
    object NavigateBack : NavigationEvent()
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "article_list_screen") {
        composable("article_list_screen") {
            val viewModel = hiltViewModel<ArticleListViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val navigationEvent = rememberFlowWithLifecycle(viewModel.navigationEvent)

            LaunchedEffect(navigationEvent) {
                navigationEvent.collect { event ->
                    when (event) {
                        is NavigationEvent.NavigateToArticle -> {
                            navController.navigate(
                                "article_detail_screen/${event.articleId}"
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
        composable(
            "article_detail_screen/{articleId}",
            arguments = listOf(
                navArgument("articleId") {
                    type = NavType.IntType
                }
            )
        ) {
            val articleId = remember {
                it.arguments?.getInt("articleId")
            }

            // TODO: Handle the case where articleId is null
            articleId?.let {
                val context = LocalContext.current
                val viewModel = hiltViewModel<ArticleDetailViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                val navigationEvent = rememberFlowWithLifecycle(viewModel.navigationEvent)
                val urlIntentEvent = rememberFlowWithLifecycle(viewModel.urlIntentEvent)

                LaunchedEffect(navigationEvent) {
                    navigationEvent.collect { event ->
                        when (event) {
                            is NavigationEvent.NavigateBack -> {
                                navController.popBackStack()
                            }

                            else -> Unit
                        }
                    }
                }

                LaunchedEffect(urlIntentEvent) {
                    urlIntentEvent.collect { url ->
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        )
                    }
                }

                // TODO: Find a solution for this
                viewModel.onEvent(
                    ArticleDetailEvent
                        .LoadArticleDetail(
                            articleId = it
                        )
                )

                ArticleDetailScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}