package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

@Composable
fun ArticleDetail(
    article: Article
) {
   Column {

   }
}

@Preview
@Composable
private fun ArticleDetailPreview() {
    SpaceflightNewsTheme {
        ArticleDetail(
            article = getSampleArticleList()[0]
        )
    }
}