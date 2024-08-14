package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.ImageArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.getFullDate

@Composable
fun ArticleListItem(
    modifier: Modifier = Modifier,
    article: Article,
    onArticleItemClick: (articleId: Int) -> Unit
) {
    Row(
        modifier = modifier
            .clickable {
                onArticleItemClick(article.id)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageArticle(
            modifier = modifier
                .size(
                    dimensionResource(
                        id = R.dimen.height_article_list_image
                    )
                )
                .clip(
                    RoundedCornerShape(
                        dimensionResource(
                            id = R.dimen.size_rounded_corner_shape
                        )
                    ),
                ),
            contentScale = ContentScale.Crop,
            imageUrl = article.imageUrl
        )
        Column(
            modifier = Modifier
                .padding(
                    start = dimensionResource(
                        id = R.dimen.spacing16
                    )
                )
                .weight(1f)
        ) {
            Text(
                text = article.title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = article.publishedAt.getFullDate(),
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                    alpha = 0.6f
                ),
                style = MaterialTheme.typography.labelLarge
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