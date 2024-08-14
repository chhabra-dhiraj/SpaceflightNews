package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.repository

import io.github.chhabra_dhiraj.spaceflightnews.data.mapper.toArticle
import io.github.chhabra_dhiraj.spaceflightnews.data.mapper.toArticleList
import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article
import io.github.chhabra_dhiraj.spaceflightnews.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.DataError
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.Result
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRepository {

    override suspend fun getArticleList(): Result<List<Article>, DataError.Network> {
        return try {
            Result.Success(
                data = api.getArticleList().toArticleList()
            )
        } catch (e: Exception) {
            getExceptionError(e)
        }
    }

    override suspend fun getArticle(articleId: Int): Result<Article, DataError.Network> {
        return try {
            Result.Success(
                data = api.getArticle(
                    articleId = articleId
                ).toArticle()
            )
        } catch (e: Exception) {
            getExceptionError(e)
        }
    }

    private fun <D> getExceptionError(e: Exception): Result<D, DataError.Network> {
        e.printStackTrace()
        return when (e) {
            is IOException -> Result.Error(DataError.Network.NO_INTERNET)
            is HttpException -> {
                when (e.code()) {
                    408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                    else -> Result.Error(DataError.Network.UNKNOWN)
                }
            }

            else -> Result.Error(DataError.Network.UNKNOWN)
        }
    }
}