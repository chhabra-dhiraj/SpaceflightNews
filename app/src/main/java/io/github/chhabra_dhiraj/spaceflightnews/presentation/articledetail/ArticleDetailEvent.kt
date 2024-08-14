package io.github.chhabra_dhiraj.spaceflightnews.presentation.articledetail

sealed interface ArticleDetailEvent {
    data class LoadArticleDetail(val articleId: Int) : ArticleDetailEvent
    data class OnViewFullArticleClick(val url: String) : ArticleDetailEvent
    object OnBackButtonClick : ArticleDetailEvent
}