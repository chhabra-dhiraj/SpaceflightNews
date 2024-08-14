package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleDto
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleListDto
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.util.getLocalDateTime
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

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

fun ArticleListDto.toArticleList() = articles.map {
    it.toArticle()
}