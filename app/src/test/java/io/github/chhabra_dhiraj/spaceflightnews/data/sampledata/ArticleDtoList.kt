package io.github.chhabra_dhiraj.spaceflightnews.data.sampledata

import io.github.chhabra_dhiraj.spaceflightnews.data.remote.ArticleDto

fun getSampleArticleDtoList() = listOf(
    ArticleDto(
        id = 1,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
        publishedAt = "2024-08-12T23:22:13Z",
        updatedAt = "2024-08-12T23:22:13Z",
        isFeatured = true
    ),
    ArticleDto(
        id = 2,
        title = "Space News title",
        url = "https://spaceflightnow.com/2024/08/11/live-coverage-spacex-to-launch-23-starlink-satellites-from-the-kennedy-space-center/",
        imageUrl = "http://spaceflightnow.com/wp-content/uploads/2024/08/20240810_Starlink_10-7_prelaunch.jpg",
        newsSite = "News Site",
        summary = "A long summary for the news",
        publishedAt = "2024-08-12T23:22:13Z",
        updatedAt = "2024-08-12T23:22:13Z",
        isFeatured = true
    )
)