package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.mapper

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticleDto
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote.ArticlesDto
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.util.getLocalDateTime
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article

fun ArticleDto.toArticle() = Article(
    id = id,
    title = title,
    url = url,
    imageUrl = imageUrl,
    newsSite = newsSite,
    summary = summary,
    publishedAt = publishedAt.getLocalDateTime(),
    updatedAt = updatedAt.getLocalDateTime(),
    isFeatured = isFeatured
)

fun ArticlesDto.toArticleList() = articles.map {
    it.toArticle()
}