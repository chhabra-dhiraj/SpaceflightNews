package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.articledetail

// TODO: Check if it is a good idea to add refresh article and what to do about the
//  list if the detail is refreshed
sealed interface ArticleDetailEvent {
    // TODO: Check if it is a good idea to initialise data with onEvent fun
    data class LoadArticleDetail(val articleId: Int) : ArticleDetailEvent
    data class OnViewFullArticleClick(val url: String) : ArticleDetailEvent
}