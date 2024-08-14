package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme

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


@Preview
@Composable
private fun ArticleListPreview() {
    SpaceflightNewsTheme {
        ArticleList(
            articles = getSampleArticleList(),
            onArticleItemClick = {}
        )
    }
}