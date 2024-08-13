package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail.component

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata.getSampleArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component.ImageArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util.getFullDateTime

@Composable
fun ArticleDetail(
    article: Article,
    onViewFullArticleClick: (url: String) -> Unit
) {
    val publishTime = article.publishedAt
    val updatedTime = article.updatedAt
    // TODO: Check if remember is required
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
                .padding(16.dp)
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Text(
                text = article.title,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.newsSite,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = stringResource(
                    R.string.str_article_detail_published_time,
                    publishTime.getFullDateTime()
                ),
                color = MaterialTheme.colorScheme.outline, // TODO: replace this with subtitle
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
            if (isArticleUpdated) {
                Text(
                    text = stringResource(
                        R.string.str_article_detail_updated_time,
                        updatedTime.getFullDateTime()
                    ),
                    color = MaterialTheme.colorScheme.outline, // TODO: replace this with subtitle
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }
            if (article.isFeatured) {
                Text(
                    text = stringResource(R.string.str_article_detail_featured),
                    color = MaterialTheme.colorScheme.outline, // TODO: replace this with subtitle
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            ImageArticle(
                imageUrl = article.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp)) // TODO: Remove spacer throughout the app
            Text(
                text = article.summary,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(80.dp)) // For Gradient
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    )
                )
        ) {
            Button(
                onClick = {
                    onViewFullArticleClick(article.url)
                }
            ) {
                Text(text = stringResource(R.string.btn_article_detail_view_full_article))
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