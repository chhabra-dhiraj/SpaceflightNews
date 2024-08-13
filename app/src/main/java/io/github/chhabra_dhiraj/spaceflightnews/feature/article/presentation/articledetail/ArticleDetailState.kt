package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

import androidx.annotation.StringRes
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

data class ArticleDetailState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    @StringRes val errorRes: Int? = null
)