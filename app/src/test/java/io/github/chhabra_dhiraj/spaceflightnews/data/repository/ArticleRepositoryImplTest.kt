package io.github.chhabra_dhiraj.spaceflightnews.data.repository

import io.github.chhabra_dhiraj.spaceflightnews.data.mapper.toArticle
import io.github.chhabra_dhiraj.spaceflightnews.data.mapper.toArticleList
import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleApi
import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleListDto
import io.github.chhabra_dhiraj.spaceflightnews.data.sampledata.getSampleArticleDtoList
import io.github.chhabra_dhiraj.spaceflightnews.domain.repository.ArticleRepository
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.DataError
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.Result
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.HttpException

class ArticleRepositoryImplTest {

    private lateinit var api: ArticleApi
    private lateinit var repository: ArticleRepository

    @Before
    fun setup() {
        api = mock(ArticleApi::class.java)
        repository = ArticleRepositoryImpl(api)
    }

    @Test
    fun `Article List Success`() = runBlocking {
        val articleDtoList = getSampleArticleDtoList()
        val articleListDto = ArticleListDto(
            articleList = articleDtoList
        )

        `when`(api.getArticleList()).thenReturn(
            articleListDto
        )

        val result = repository.getArticleList()
        assert((result as? Result.Success)?.data == articleListDto.toArticleList())
    }

    @Test
    fun `Article List Error`() = runBlocking {
        val exception = mock(HttpException::class.java)
        `when`(api.getArticleList()).thenThrow(exception)

        val result = repository.getArticleList()
        assert(result is Result.Error)
    }

    @Test
    fun `Article List Error - Request Timeout`() = runBlocking {
        val httpException = mock(HttpException::class.java)
        `when`(httpException.code()).thenReturn(408)
        `when`(api.getArticleList()).thenThrow(httpException)

        val result = repository.getArticleList()
        assert((result as? Result.Error)?.error == DataError.Network.REQUEST_TIMEOUT)
    }

    @Test
    fun `Article List Error - Unknown Error`() = runBlocking {
        val httpException = mock(HttpException::class.java)
        `when`(httpException.code()).thenReturn(409)
        `when`(api.getArticleList()).thenThrow(httpException)

        val result = repository.getArticleList()
        assert((result as? Result.Error)?.error == DataError.Network.UNKNOWN)
    }

    @Test
    fun `Article Detail Success`() = runBlocking {
        val articleDto = getSampleArticleDtoList()[0]
        val articleId = 1

        `when`(api.getArticle(articleId = articleId)).thenReturn(articleDto)

        val result = repository.getArticle(articleId = articleId)
        assert((result as? Result.Success)?.data == articleDto.toArticle())
    }

    @Test
    fun `Article Detail Error`() = runBlocking {
        val exception = mock(HttpException::class.java)
        val articleId = 1

        `when`(api.getArticle(articleId = articleId)).thenThrow(exception)

        val result = repository.getArticle(articleId = articleId)
        assert(result is Result.Error)
    }

    @Test
    fun `Article Detail Error - Request Timeout`() = runBlocking {
        val httpException = mock(HttpException::class.java)
        `when`(httpException.code()).thenReturn(408)
        val articleId = 1

        `when`(api.getArticle(articleId = articleId)).thenThrow(httpException)

        val result = repository.getArticle(articleId = articleId)
        assert((result as? Result.Error)?.error == DataError.Network.REQUEST_TIMEOUT)
    }

    @Test
    fun `Article Detail Error - Unknown Error`() = runBlocking {
        val httpException = mock(HttpException::class.java)
        `when`(httpException.code()).thenReturn(409)
        val articleId = 1

        `when`(api.getArticle(articleId = articleId)).thenThrow(httpException)

        val result = repository.getArticle(articleId = articleId)
        assert((result as? Result.Error)?.error == DataError.Network.UNKNOWN)
    }
}