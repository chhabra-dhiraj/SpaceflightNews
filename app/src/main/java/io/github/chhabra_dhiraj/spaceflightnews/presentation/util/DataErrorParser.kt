package io.github.chhabra_dhiraj.spaceflightnews.presentation.util

import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.DataError
import io.github.chhabra_dhiraj.spaceflightnews.domain.util.Result

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(
            R.string.str_error_request_timed_out
        )

        DataError.Network.NO_INTERNET -> UiText.StringResource(
            R.string.str_error_no_internet
        )

        DataError.Network.UNKNOWN -> UiText.StringResource(
            R.string.str_error_unknown
        )
    }
}

fun Result.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}