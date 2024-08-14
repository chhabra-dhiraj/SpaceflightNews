package io.github.chhabra_dhiraj.spaceflightnews.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleListDto(
    @SerialName("results")
    val articleList: List<ArticleDto>
)