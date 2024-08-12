package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import coil.compose.SubcomposeAsyncImage
import io.github.chhabra_dhiraj.spaceflightnews.R

@Composable
fun ArticleImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = null,
        loading = {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.scale(0.3f)
            )
        },
        error = {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_newspaper_24),
                contentDescription = null
            )
        },
        modifier = modifier
    )
}