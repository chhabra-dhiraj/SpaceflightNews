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
        summary = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
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