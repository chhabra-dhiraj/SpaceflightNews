package io.github.chhabra_dhiraj.spaceflightnews.domain.model

import java.time.LocalDateTime

data class Article(
    val id: Int,
    val title: String,
    val url: String,
    val imageUrl: String,
    val newsSite: String,
    val summary: String,
    val publishedAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val isFeatured: Boolean
)