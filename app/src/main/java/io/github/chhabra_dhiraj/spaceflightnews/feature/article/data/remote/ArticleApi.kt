package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote

import retrofit2.http.GET

interface ArticleApi {

    companion object {
        const val ARTICLE_LIST = "articles/"
    }

    @GET(ARTICLE_LIST)
    suspend fun getArticles(): ArticlesDto
}