package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

import androidx.annotation.StringRes
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

data class ArticleListState(
    val articles: List<Article>? = null,
    val isLoading: Boolean = false,
    @StringRes val errorRes: Int? = null
)