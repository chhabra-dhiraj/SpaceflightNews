package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.ImageArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util.getFullDate

@Composable
fun ArticleListItem(
    article: Article,
    onArticleItemClick: (articleId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable {
                onArticleItemClick(article.id)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageArticle(
            imageUrl = article.imageUrl,
            modifier = modifier
                .clip(
                    RoundedCornerShape(24.dp),
                )
                .size(120.dp),
        )

        Spacer(Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = article.title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = article.publishedAt.getFullDate(),
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.outline // TODO: Change this to subtitle
            )
        }
    }
}


@Preview
@Composable
private fun ArticleListItemPreview() {
    SpaceflightNewsTheme {
        ArticleListItem(
            article = getSampleArticleList()[0],
            onArticleItemClick = {}
        )
    }
}