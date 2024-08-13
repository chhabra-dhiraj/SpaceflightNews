package io.github.chhabra_dhiraj.spaceflightnews

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailEvent
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailScreen
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.ArticleDetailViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListScreen
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.ArticleListViewModel
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util.rememberFlowWithLifecycle
import kotlinx.serialization.Serializable

@Immutable
sealed class NavigationEvent {
    data class NavigateToArticle(val articleId: Int) : NavigationEvent()
    object NavigateBack : NavigationEvent()
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ArticleList
    ) {
        composable<ArticleList> {
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
        composable<ArticleDetail> {
            val args = it.toRoute<ArticleDetail>()
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
                    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { intent ->
                        context.startActivity(intent)
                    }
                }
            }

            // TODO: Find a solution for this
            viewModel.onEvent(
                ArticleDetailEvent
                    .LoadArticleDetail(
                        articleId = args.articleId
                    )
            )

            ArticleDetailScreen(
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }
}

@Serializable
object ArticleList

@Serializable
data class ArticleDetail(val articleId: Int)