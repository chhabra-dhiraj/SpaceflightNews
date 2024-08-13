package io.github.chhabra_dhiraj.spaceflightnews.feature.article.data.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getLocalDateTime(value: String) = try {
    LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME)
} catch (e: Exception) {
    e.printStackTrace()
    // To avoid app crash, and instead, use an appropriate placeholder
    null
}