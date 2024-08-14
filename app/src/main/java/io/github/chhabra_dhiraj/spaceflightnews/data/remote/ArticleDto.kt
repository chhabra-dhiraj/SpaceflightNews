package io.github.chhabra_dhiraj.spaceflightnews.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val id: Int,
    val title: String,
    val url: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("news_site")
    val newsSite: String,
    val summary: String,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("featured")
    val isFeatured: Boolean
)