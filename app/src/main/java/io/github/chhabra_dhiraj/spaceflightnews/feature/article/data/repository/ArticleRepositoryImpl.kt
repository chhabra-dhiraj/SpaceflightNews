package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.repository

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper.toArticle
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper.toArticleList
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.Resource
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRepository {

    override suspend fun getArticleList(): Resource<List<Article>> {
        return try {
            Resource.Success(
                data = api.getArticleList().toArticleList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            // TODO: extract string to a string resource
            Resource.Error(message = e.message ?: "An unknown error occurred!")
        }
    }

    override suspend fun getArticle(articleId: Int): Resource<Article> {
        return try {
            Resource.Success(
                data = api.getArticle(
                    articleId = articleId
                ).toArticle()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            // TODO: extract string to a string resource
            Resource.Error(message = e.message ?: "An unknown error occurred!")
        }
    }
}