package io.github.chhabra_dhiraj.spaceflightnews.feature.article.presentation.util

import androidx.annotation.StringRes
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.feature.article.domain.util.DataError

@StringRes
fun DataError.getErrorRes(): Int {
    return when (this) {
        DataError.Network.REQUEST_TIMEOUT -> R.string.str_error_request_timed_out

        DataError.Network.NO_INTERNET -> R.string.str_error_no_internet

        DataError.Network.UNKNOWN -> R.string.str_error_unknown
    }
}