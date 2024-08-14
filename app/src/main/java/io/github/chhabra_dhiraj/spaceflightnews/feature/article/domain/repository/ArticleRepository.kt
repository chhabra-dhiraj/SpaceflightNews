package io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.util.network.DataError
import io.github.chhabra_dhiraj.spaceflightnews.util.network.Result

interface ArticleRepository {

    suspend fun getArticleList(): Result<List<Article>, DataError.Network>

    suspend fun getArticle(articleId: Int): Result<Article, DataError.Network>
}