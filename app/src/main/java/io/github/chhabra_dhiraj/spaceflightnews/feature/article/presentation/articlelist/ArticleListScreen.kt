package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.BlankArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.EmptyArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ErrorArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.LoadingArticleListState

@Composable
fun ArticleListScreen(
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            ArticleListHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ArticleListBody(
                state = state,
                onEvent = onEvent
            )
        }
    }
}

@Composable
fun ArticleListHeader(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun ArticleListBody(
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit
) {
    state.articles?.let {
        if (it.isNotEmpty()) {
            ArticleList(
                articles = it,
                onArticleItemClick = { articleId ->
                    onEvent(ArticleListEvent.OnArticleClick(articleId = articleId))
                }
            )
        } else {
            BlankArticleListState(state = {
                EmptyArticleListState()
            })
        }
    } ?: run {
        if (state.isLoading) {
            BlankArticleListState(state = {
                LoadingArticleListState()
            })
            return
        }

        state.error?.let {
            BlankArticleListState(state = {
                ErrorArticleListState(
                    error = it,
                    onRetry = {
                        onEvent(ArticleListEvent.OnRetryLoadArticleList)
                    }
                )
            })
        }
    }
}