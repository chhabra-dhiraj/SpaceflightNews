package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.repository

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper.toArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleApi: ArticleApi
) : ArticleRepository {
    override suspend fun getArticles(lat: Double, long: Double): Resource<List<Article>> {
        return try {
            Resource.Success(
                data = articleApi.getArticles().toArticleList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An unknown error occurred!")
        }
    }
}