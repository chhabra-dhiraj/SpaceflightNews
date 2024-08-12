package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.EmptyArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ErrorArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.LoadingArticleListState
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.PlaceholderArticleList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleListScreen(
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    ArticleListHeader(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(ArticleListEvent.OnRefreshArticleList)
                },
                shape = RoundedCornerShape(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = stringResource(R.string.cd_refresh_article_list)
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        ArticleListBody(
            state = state,
            onEvent = onEvent,
            modifier = Modifier
                .padding(contentPadding)
        )
    }
}

@Composable
fun ArticleListHeader(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun ArticleListBody(
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        state.articles?.let {
            if (it.isNotEmpty()) {
                ArticleList(
                    articles = it,
                    onArticleItemClick = { articleId ->
                        onEvent(ArticleListEvent.OnArticleClick(articleId = articleId))
                    }
                )
            } else {
                PlaceholderArticleList(state = {
                    EmptyArticleListState()
                })
            }
        } ?: run {
            if (state.isLoading) {
                PlaceholderArticleList(state = {
                    LoadingArticleListState()
                })
            } else {
                state.error?.let {
                    PlaceholderArticleList(state = {
                        ErrorArticleListState(error = it)
                    })
                }
            }
        }
    }
}