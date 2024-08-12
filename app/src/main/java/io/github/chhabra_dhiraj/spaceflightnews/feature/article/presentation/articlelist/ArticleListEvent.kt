package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articlelist

sealed interface ArticleListEvent {
    data class OnArticleClick(val articleId: Int): ArticleListEvent
    object OnRetryLoadArticleList: ArticleListEvent
}