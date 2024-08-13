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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.EmptyPlaceholderArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.ErrorPlaceholderArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.LoadingPlaceholderArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component.PlaceholderArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

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
        // TODO: Handle padding overlap for this fab
        floatingActionButton = {
            ArticleListRefreshFab(
                onRefresh = {
                    onEvent(ArticleListEvent.OnRefreshArticleList)
                }
            )
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
                PlaceholderArticleList(placeholder = {
                    EmptyPlaceholderArticleList()
                })
            }
        } ?: run {
            if (state.isLoading) {
                PlaceholderArticleList(placeholder = {
                    LoadingPlaceholderArticleList()
                })
            } else {
                state.error?.let {
                    PlaceholderArticleList(placeholder = {
                        ErrorPlaceholderArticleList(error = it)
                    })
                }
            }
        }
    }
}

@Composable
fun ArticleListRefreshFab(
    onRefresh: () -> Unit
) {
    FloatingActionButton(
        onClick = { onRefresh() },
        shape = RoundedCornerShape(20.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = stringResource(R.string.cd_refresh_article_list)
        )
    }
}

// For Article List
@Preview
@Composable
private fun ArticleListScreenPreview() {
    SpaceflightNewsTheme {
        ArticleListScreen(
            state =   ArticleListState(
                articles = getSampleArticleList(),
                isLoading = false,
                error = null
            ),
            onEvent = {}
        )
    }
}

// For Empty Article List
@Preview
@Composable
private fun EmptyArticleListScreenPreview() {
    SpaceflightNewsTheme {
        ArticleListScreen(
            state =   ArticleListState(
                articles = emptyList(),
                isLoading = false,
                error = null
            ),
            onEvent = {}
        )
    }
}

// For Loading Article List
@Preview
@Composable
private fun LoadingArticleListScreenPreview() {
    SpaceflightNewsTheme {
        ArticleListScreen(
            state =   ArticleListState(
                articles = null,
                isLoading = true,
                error = null
            ),
            onEvent = {}
        )
    }
}

// For Article List Error
@Preview
@Composable
private fun ArticleListScreenErrorPreview() {
    SpaceflightNewsTheme {
        ArticleListScreen(
            state =   ArticleListState(
                articles = null,
                isLoading = false,
                // TODO: extract to a stringResource. Blocker: Using the same in data layer.
                error = "An unknown error occurred!"
            ),
            onEvent = {}
        )
    }
}