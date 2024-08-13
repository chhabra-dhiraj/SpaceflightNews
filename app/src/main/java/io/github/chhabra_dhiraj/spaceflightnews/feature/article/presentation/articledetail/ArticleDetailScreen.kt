package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.component.ArticleDetail
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.BackButtonArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.ErrorPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.HeaderArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.LoadingPlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.PlaceholderArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(
    state: ArticleDetailState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    BackButtonArticle()
                },
                title = {
                    HeaderArticle(
                        title = getArticleDetailScreenTitle(
                            newsSite = state.article?.newsSite
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                })
        }
    ) { contentPadding ->
        ArticleDetailBody(
            state = state,
            modifier = Modifier
                .padding(contentPadding)
        )
    }
}

@Composable
fun ArticleDetailBody(
    state: ArticleDetailState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        state.article?.let {
            ArticleDetail(article = it)
        } ?: run {
            if (state.isLoading) {
                PlaceholderArticle(placeholder = {
                    LoadingPlaceholderArticle()
                })
            } else {
                state.error?.let {
                    PlaceholderArticle(placeholder = {
                        ErrorPlaceholderArticle(error = it)
                    })
                }
            }
        }
    }
}

// TODO: Check if need to use remember block and whether this can be a private fun or not
@Composable
private fun getArticleDetailScreenTitle(
    newsSite: String?
) = newsSite ?: ""

// For Article Detail
@Preview
@Composable
private fun ArticleDetailScreenPreview() {
    SpaceflightNewsTheme {
        ArticleDetailScreen(
            state = ArticleDetailState(
                article = getSampleArticleList()[0]
            )
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
            )
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
                // TODO: extract to a stringResource. Blocker: Using the same in data layer.
                error = "An unknown error occurred!"
            )
        )
    }
}
