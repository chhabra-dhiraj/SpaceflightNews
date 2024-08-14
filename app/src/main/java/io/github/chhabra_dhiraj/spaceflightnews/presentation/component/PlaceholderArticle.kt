package io.github.chhabra_dhiraj.spaceflightnews.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme

/**
 * For the case when the list is not available because of the following reasons:
 * 1. loading
 * 2. error
 * 3. empty list
 * */
@Composable
fun PlaceholderArticle(
    placeholder: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                dimensionResource(
                    id = R.dimen.spacing32
                )
            ),
        contentAlignment = Center
    ) {
        placeholder()
    }
}

@Composable
fun EmptyPlaceholderArticle(
    title: String = stringResource(R.string.str_empty_placeholder_article_list_title),
    subtitle: String = stringResource(R.string.str_empty_placeholder_article_list_subtitle)
) {
    Column {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .padding(
                    top = dimensionResource(
                        id = R.dimen.spacing8
                    )
                ),
            text = subtitle,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                alpha = 0.6f
            ),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun LoadingPlaceholderArticle() {
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun ErrorPlaceholderArticle(
    error: String
) {
    Text(
        text = error,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview
@Composable
private fun EmptyPlaceholderArticlePreview() {
    SpaceflightNewsTheme {
        PlaceholderArticle {
            EmptyPlaceholderArticle()
        }
    }
}

@Preview
@Composable
private fun LoadingPlaceholderArticlePreview() {
    SpaceflightNewsTheme {
        PlaceholderArticle {
            LoadingPlaceholderArticle()
        }
    }
}

@Preview
@Composable
private fun ErrorPlaceholderArticlePreview() {
    SpaceflightNewsTheme {
        PlaceholderArticle {
            ErrorPlaceholderArticle(
                error = stringResource(id = R.string.str_error_unknown)
            )
        }
    }
}