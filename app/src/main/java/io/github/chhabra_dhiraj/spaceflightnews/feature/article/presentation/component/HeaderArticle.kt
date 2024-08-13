package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.ui.theme.SpaceflightNewsTheme

@Composable
fun HeaderArticle(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title
        )
    }
}

@Preview
@Composable
private fun HeaderArticlePreview() {
    SpaceflightNewsTheme {
        HeaderArticle(title = stringResource(id = R.string.app_name))
    }
}