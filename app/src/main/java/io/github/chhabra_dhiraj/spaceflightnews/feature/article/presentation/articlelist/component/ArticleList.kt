package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

@Composable
fun ArticleList(
    articles: List<Article>,
    onArticleItemClick: (articleId: Int) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(
            items = articles,
            key = { it.id }
        ) { article ->
            ArticleListItem(
                article = article,
                onArticleItemClick = onArticleItemClick
            )
        }
    }
}