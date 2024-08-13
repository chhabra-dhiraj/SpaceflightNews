package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val NOT_AVAILABLE = "N/A"
const val FULL_DATE_FORMAT = "MMMM d, yyyy"

fun LocalDateTime?.getFullDate() = this?.let {
    format(
        DateTimeFormatter.ofPattern(FULL_DATE_FORMAT)
    )
} ?: NOT_AVAILABLE