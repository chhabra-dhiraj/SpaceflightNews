package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ArticleImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    // TODO: check if this is supported. And, add error placeholder
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier
    )
}