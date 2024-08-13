package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

data class ArticleDetailState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)