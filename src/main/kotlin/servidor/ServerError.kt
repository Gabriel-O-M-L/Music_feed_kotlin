package servidor

data class ServerError (
    val status: Int,
    val message: String
)