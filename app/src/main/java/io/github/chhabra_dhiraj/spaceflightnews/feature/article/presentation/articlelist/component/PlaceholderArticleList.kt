package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.chhabra_dhiraj.spaceflightnews.R

/**
 * For the case when the list is not available because of the following reasons:
 * 1. loading
 * 2. error
 * 3. empty list
 * */
@Composable
fun PlaceholderArticleList(
    state: @Composable () -> Unit
) {
    Box(
        contentAlignment = Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp)
    ) {
        state()
    }
}

@Composable
fun EmptyArticleListState(
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.empty_article_list_state_title),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.empty_article_list_state_subtitle),
            color = MaterialTheme.colorScheme.outline, // TODO: change this with subtitle color
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            colors = ButtonDefaults.buttonColors(),
            onClick = { onRefresh() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}

@Composable
fun LoadingArticleListState(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun ErrorArticleListState(
    error: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = error,
            color = MaterialTheme.colorScheme.error,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            colors = ButtonDefaults.buttonColors(),
            onClick = { onRetry() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}

