package io.github.chhabra_dhiraj.spaceflightnews.data.mapper

import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleDto
import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleListDto
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.util.getLocalDateTime
import io.github.chhabra_dhiraj.spaceflightnews.domain.model.Article

fun ArticleDto.toArticle() = Article(
    id = id,
    title = title,
    url = url,
    imageUrl = imageUrl,
    newsSite = newsSite,
    summary = summary,
    publishedAt = getLocalDateTime(publishedAt),
    updatedAt = getLocalDateTime(updatedAt),
    isFeatured = isFeatured
)

fun ArticleListDto.toArticleList() = articleList.map {
    it.toArticle()
}