package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import io.github.chhabra_dhiraj.spaceflightnews.R

@Composable
fun BackButtonArticle(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_west_24),
        contentDescription = null,
        modifier = modifier
            .clickable {
                // TODO: Along with navigation implementation
                //navController.popBackStack()
            }
    )
}