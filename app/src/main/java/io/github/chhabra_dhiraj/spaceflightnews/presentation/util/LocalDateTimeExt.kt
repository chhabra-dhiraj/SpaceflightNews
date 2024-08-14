package io.github.chhabra_dhiraj.spaceflightnews.presentation.util

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

const val NOT_AVAILABLE = "N/A"
const val FULL_DATE_FORMAT = "MMMM d, yyyy"
const val FULL_DATE_TIME_FORMAT = "MMMM d, yyyy hh:mm a"

fun LocalDateTime?.getFullDate() = this?.getZonedDateTime()?.format(
    DateTimeFormatter.ofPattern(FULL_DATE_FORMAT)
) ?: NOT_AVAILABLE


fun LocalDateTime?.getFullDateTime() = this?.getZonedDateTime()?.format(
    DateTimeFormatter.ofPattern(FULL_DATE_TIME_FORMAT)
) ?: NOT_AVAILABLE

private fun LocalDateTime.getZonedDateTime() = atZone(ZoneId.systemDefault())