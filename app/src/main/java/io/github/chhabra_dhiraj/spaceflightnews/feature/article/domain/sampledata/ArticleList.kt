package io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.sampledata

import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.model.Article
import java.time.LocalDateTime

/** Sample data (mainly for debugging or previews) */
fun getSampleArticleList() = listOf(
    Article(
        id = 1,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = true
    ),
    Article(
        id = 2,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = true
    ),
    Article(
        id = 3,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = true
    ),
    Article(
        id = 4,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = false
    ),
    Article(
        id = 5,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = false
    ),
    Article(
        id = 6,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = false
    ),
    Article(
        id = 7,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = LocalDateTime.now().minusHours(1),
        updatedAt = LocalDateTime.now(),
        isFeatured = false
    )
)