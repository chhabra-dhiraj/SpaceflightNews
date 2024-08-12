package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.chhabra_dhiraj.spaceflightnews.R

@Composable
fun ArticleListRefreshFab(
    onRefresh: () -> Unit
) {
    FloatingActionButton(
        onClick = { onRefresh() },
        shape = RoundedCornerShape(20.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = stringResource(R.string.cd_refresh_article_list)
        )
    }
}