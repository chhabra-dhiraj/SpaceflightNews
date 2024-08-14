package io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.presentation.component.ImageArticle
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.getFullDateTime

@Composable
fun ArticleDetail(
    article: Article,
    onViewFullArticleClick: (url: String) -> Unit
) {
    val publishTime = article.publishedAt
    val updatedTime = article.updatedAt
    val isArticleUpdated = remember(updatedTime) {
        publishTime ?: return@remember true
        updatedTime ?: return@remember true
        return@remember !publishTime.isEqual(updatedTime)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    dimensionResource(
                        id = R.dimen.spacing16
                    )
                )
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Text(
                text = article.title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(
                    top = dimensionResource(id = R.dimen.spacing16)
                ),
                text = article.newsSite,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = stringResource(
                    R.string.str_article_detail_published_time,
                    publishTime.getFullDateTime()
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                    alpha = 0.6f
                ),
                style = MaterialTheme.typography.labelMedium
            )
            if (isArticleUpdated) {
                Text(
                    text = stringResource(
                        R.string.str_article_detail_updated_time,
                        updatedTime.getFullDateTime()
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        alpha = 0.6f
                    ),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            if (article.isFeatured) {
                Text(
                    text = stringResource(R.string.str_article_detail_featured),
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        alpha = 0.6f
                    ),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            ImageArticle(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(
                            id = R.dimen.spacing24
                        )
                    )
                    .fillMaxWidth()
                    .height(
                        dimensionResource(
                            id = R.dimen.height_article_detail_image
                        )
                    ),
                imageUrl = article.imageUrl
            )
            Text(
                modifier = Modifier.padding(
                    top = dimensionResource(
                        id = R.dimen.spacing16
                    )
                ),
                text = article.summary,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(
                        id = R.dimen.spacing_article_detail_gradient
                    )
                )
            ) // For Gradient
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    dimensionResource(
                        id = R.dimen.height_article_detail_gradient
                    )
                )
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    onViewFullArticleClick(article.url)
                }
            ) {
                Text(
                    text = stringResource(R.string.btn_article_detail_view_full_article),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun ArticleDetailPreview() {
    SpaceflightNewsTheme {
        ArticleDetail(
            article = getSampleArticleList()[0],
            onViewFullArticleClick = {}
        )
    }
}