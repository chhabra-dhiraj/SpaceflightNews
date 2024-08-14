package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist.component.ArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.EmptyPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.ErrorPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.HeaderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.LoadingPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.PlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.UiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleListScreen(
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    HeaderArticle(
                        modifier = Modifier
                            .fillMaxWidth(),
                        title = stringResource(id = R.string.app_name),
                    )
                })
        },
        floatingActionButton = {
            ArticleListRefreshFab(
                modifier = Modifier
                    .padding(
                        end = WindowInsets.systemBars.asPaddingValues()
                            .calculateEndPadding(LayoutDirection.Ltr)
                    ),
                onRefresh = {
                    onEvent(ArticleListEvent.OnRefreshArticleList)
                }
            )
        }
    ) { contentPadding ->
        ArticleListBody(
            modifier = Modifier
                .padding(contentPadding),
            state = state,
            onEvent = onEvent
        )
    }
}

@Composable
fun ArticleListBody(
    modifier: Modifier = Modifier,
    state: ArticleListState,
    onEvent: (ArticleListEvent) -> Unit
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
                PlaceholderArticle(placeholder = {
                    EmptyPlaceholderArticle()
                })
            }
        } ?: run {
            if (state.isLoading) {
                PlaceholderArticle(placeholder = {
                    LoadingPlaceholderArticle()
                })
            } else {
                state.error?.let {
                    PlaceholderArticle(placeholder = {
                        ErrorPlaceholderArticle(error = it.asString())
                    })
                }
            }
        }
    }
}

@Composable
fun ArticleListRefreshFab(
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { onRefresh() },
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.size_rounded_corner_shape
            )
        )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                id = R.drawable.baseline_refresh_24
            ),
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
            state = ArticleListState(
                articles = getSampleArticleList()
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
            state = ArticleListState(
                articles = emptyList()
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
            state = ArticleListState(
                isLoading = true
            ),
            onEvent = {}
        )
    }
}

// For Article List Error
@Preview
@Composable
private fun ErrorArticleListScreenPreview() {
    SpaceflightNewsTheme {
        ArticleListScreen(
            state = ArticleListState(
                error = UiText.StringResource(
                    id = R.string.str_error_unknown
                )
            ),
            onEvent = {}
        )
    }
}