package io.github.chhabra_dhiraj.spaceflightnews.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.presentation.ui.theme.SpaceflightNewsTheme

@Composable
fun BackButtonArticle(
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit
) {
    Icon(
        imageVector = ImageVector.vectorResource(
            id = R.drawable.baseline_arrow_back_ios_24
        ),
        contentDescription = null,
        modifier = modifier
            .clickable {
                onBackButtonClick()
            }
    )
}

@Preview
@Composable
private fun BackButtonArticlePreview() {
    SpaceflightNewsTheme {
        BackButtonArticle(
            onBackButtonClick = {}
        )
    }
}