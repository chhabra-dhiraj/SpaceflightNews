package io.github.chhabra_dhiraj.spaceflightnews.util.error

import androidx.annotation.StringRes
import io.github.chhabra_dhiraj.spaceflightnews.R
import io.github.chhabra_dhiraj.spaceflightnews.util.network.DataError

@StringRes
fun DataError.getErrorRes(): Int {
    return when (this) {
        DataError.Network.REQUEST_TIMEOUT -> R.string.str_error_request_timed_out

        DataError.Network.NO_INTERNET -> R.string.str_error_no_internet

        DataError.Network.UNKNOWN -> R.string.str_error_unknown
    }
}