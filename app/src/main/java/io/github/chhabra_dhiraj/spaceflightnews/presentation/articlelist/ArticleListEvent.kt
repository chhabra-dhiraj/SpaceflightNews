package io.github.chhabra_dhiraj.spaceflightnews.presentation.articlelist

sealed interface ArticleListEvent {
    data class OnArticleClick(val articleId: Int): ArticleListEvent
    object OnRefreshArticleList: ArticleListEvent
}