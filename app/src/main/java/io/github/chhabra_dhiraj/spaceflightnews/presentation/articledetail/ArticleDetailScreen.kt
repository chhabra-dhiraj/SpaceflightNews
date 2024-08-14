package io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail.component.ArticleDetail
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.BackButtonArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.ErrorPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.LoadingPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.PlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.UiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(
    state: ArticleDetailState,
    onEvent: (ArticleDetailEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    BackButtonArticle(
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(
                                    id = R.dimen.spacing16
                                )
                            ),
                        onBackButtonClick = {
                            onEvent(ArticleDetailEvent.OnBackButtonClick)
                        }
                    )
                },
                title = {})
        }
    ) { contentPadding ->
        ArticleDetailBody(
            modifier = Modifier
                .padding(contentPadding),
            state = state,
            onEvent = onEvent
        )
    }
}

@Composable
fun ArticleDetailBody(
    modifier: Modifier = Modifier,
    state: ArticleDetailState,
    onEvent: (ArticleDetailEvent) -> Unit
) {
    Box(modifier = modifier) {
        state.article?.let {
            ArticleDetail(
                article = it,
                onViewFullArticleClick = { url ->
                    onEvent(ArticleDetailEvent.OnViewFullArticleClick(url))
                }
            )
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

// For Article Detail
@Preview
@Composable
private fun ArticleDetailScreenPreview() {
    SpaceflightNewsTheme {
        ArticleDetailScreen(
            state = ArticleDetailState(
                article = getSampleArticleList()[0]
            ),
            onEvent = {}
        )
    }
}

// For Loading Article Detail
@Preview
@Composable
private fun LoadingArticleDetailScreenPreview() {
    SpaceflightNewsTheme {
        ArticleDetailScreen(
            state = ArticleDetailState(
                isLoading = true
            ),
            onEvent = {}
        )
    }
}

// For Article Detail Error
@Preview
@Composable
private fun ErrorArticleDetailScreenPreview() {
    SpaceflightNewsTheme {
        ArticleDetailScreen(
            state = ArticleDetailState(
                error = UiText.StringResource(
                    id = R.string.str_error_unknown
                )
            ),
            onEvent = {}
        )
    }
}
