package io.github.chhabra_dhiraj.spaceflightnews.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleApi {

    companion object HttpRoutes {
        private const val ARTICLE_LIST = "articles/"

        private const val PARAM_ARTICLE_ID = "id"
        private const val ARTICLE = "$ARTICLE_LIST{$PARAM_ARTICLE_ID}/"
    }

    @GET(ARTICLE_LIST)
    suspend fun getArticleList(): ArticleListDto

    @GET(ARTICLE)
    suspend fun getArticle(@Path(PARAM_ARTICLE_ID) articleId: Int): ArticleDto
}