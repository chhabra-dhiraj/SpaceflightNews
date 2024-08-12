package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.repository

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper.toArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRepository {
    override suspend fun getArticles(): Resource<List<Article>> {
        return try {
            Resource.Success(
                data = api.getArticles().toArticleList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An unknown error occurred!")
        }
    }
}