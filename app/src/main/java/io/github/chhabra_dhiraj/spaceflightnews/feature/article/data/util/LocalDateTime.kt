package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.getLocalDateTime() = try {
    LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
} catch (e: Exception) {
    e.printStackTrace()
    // To avoid app crash, and instead, use an appropriate placeholder (e.g. "Time Unknown")
    null
}