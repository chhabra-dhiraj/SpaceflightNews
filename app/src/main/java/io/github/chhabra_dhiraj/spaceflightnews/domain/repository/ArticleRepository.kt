package io.github.chhabra_dhiraj.spaceflightnews.domain.repository

import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.DataError
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.Result

interface ArticleRepository {

    suspend fun getArticleList(): Result<List<Article>, DataError.Network>

    suspend fun getArticle(articleId: Int): Result<Article, DataError.Network>
}