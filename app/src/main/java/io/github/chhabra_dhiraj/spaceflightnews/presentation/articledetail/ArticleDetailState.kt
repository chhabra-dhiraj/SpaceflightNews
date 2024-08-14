package io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail

import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.presentation.util.UiText

data class ArticleDetailState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    val error: UiText? = null
)