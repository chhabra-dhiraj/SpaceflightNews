package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlankArticleListState(
    state: @Composable () -> Unit
) {
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        state()
    }
}

@Composable
fun EmptyArticleListState() {
// TODO
}

@Composable
fun LoadingArticleListState() {
    // TODO
    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
}

@Composable
fun ErrorArticleListState(
    error: String,
    onRetry: () -> Unit
) {
    // TODO
    Column {
        Text(error, color = MaterialTheme.colorScheme.error, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}

