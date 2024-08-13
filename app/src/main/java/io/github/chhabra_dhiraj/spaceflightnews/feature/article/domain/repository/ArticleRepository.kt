package io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource

interface ArticleRepository {

    suspend fun getArticles(): Resource<List<Article>>

}