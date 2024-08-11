package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesDto(
    @SerialName("results")
    val articles: List<ArticleDto>
)