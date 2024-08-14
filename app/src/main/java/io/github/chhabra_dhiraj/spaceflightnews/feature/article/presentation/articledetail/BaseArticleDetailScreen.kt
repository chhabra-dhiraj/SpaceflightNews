package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.toRoute
import io.github.chhabra_dhiraj.spaceflightnews.ArticleDetail
import io.github.chhabra_dhiraj.spaceflightnews.NavigationEvent
import io.github.chhabra_dhiraj.spaceflightnews.util.compose.rememberFlowWithLifecycle

@Composable
fun BaseArticleDetailScreen(
    navBackStackEntry: NavBackStackEntry,
    navController: NavController
) {
    val args = navBackStackEntry.toRoute<ArticleDetail>()
    val context = LocalContext.current
    val viewModel = hiltViewModel<ArticleDetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val navigationEvent = rememberFlowWithLifecycle(viewModel.navigationEvent)

    LaunchedEffect(navigationEvent) {
        navigationEvent.collect { event ->
            when (event) {
                is NavigationEvent.NavigateBack -> {
                    navController.popBackStack()
                }

                is NavigationEvent.NavigateToViewFullArticle -> {
                    Intent(Intent.ACTION_VIEW, Uri.parse(event.url)).also { intent ->
                        context.startActivity(intent)
                    }
                }

                else -> Unit
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.onEvent(
            ArticleDetailEvent
                .LoadArticleDetail(
                    articleId = args.articleId
                )
        )
    }

    ArticleDetailScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}