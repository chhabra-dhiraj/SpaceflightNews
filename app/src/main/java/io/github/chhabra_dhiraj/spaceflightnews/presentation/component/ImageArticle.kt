package io.github.chhabra_dhiraj.spaceflightnews.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme

@Composable
fun ImageArticle(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentScale: ContentScale = ContentScale.Fit
) {
    SubcomposeAsyncImage(
        modifier = modifier,
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
        contentScale = contentScale
    )
}

@Preview
@Composable
private fun ImageArticlePreview() {
    SpaceflightNewsTheme {
        ImageArticle(imageUrl = "")
    }
}