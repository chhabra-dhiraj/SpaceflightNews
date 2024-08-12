package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist.state

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

data class ArticleListState(
    val articles: List<Article>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)