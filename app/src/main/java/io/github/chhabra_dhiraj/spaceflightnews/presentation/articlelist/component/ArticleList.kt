package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme

@Composable
fun ArticleList(
    articles: List<Article>,
    onArticleItemClick: (articleId: Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = dimensionResource(
                id = R.dimen.spacing16
            ),
            top = dimensionResource(
                id = R.dimen.spacing16
            ),
            end = dimensionResource(
                id = R.dimen.spacing16
            ),
            bottom = dimensionResource(
                id = R.dimen.spacing_article_list_fab
            )
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(
                id = R.dimen.spacing16
            )
        )
    ) {
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