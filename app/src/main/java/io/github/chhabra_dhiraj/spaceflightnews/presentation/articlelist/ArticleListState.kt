package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist

import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.UiText

data class ArticleListState(
    val articles: List<Article>? = null,
    val isLoading: Boolean = false,
    val error: UiText? = null
)