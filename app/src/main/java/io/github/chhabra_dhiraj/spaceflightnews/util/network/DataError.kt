package io.github.chhabra_dhiraj.spaceflightnews.util.network

sealed interface DataError : Error {
    // Handling below 3 errors, for now
    enum class Network : DataError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        UNKNOWN
    }
}