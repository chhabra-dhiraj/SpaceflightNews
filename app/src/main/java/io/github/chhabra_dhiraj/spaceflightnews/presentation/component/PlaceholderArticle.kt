package io.github.chhabra_dhiraj.spaceflightnews.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        contentAlignment = Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp)
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
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subtitle,
            color = MaterialTheme.colorScheme.outline, // TODO: change this with subtitle color
            fontSize = 14.sp
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
        fontSize = 18.sp
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