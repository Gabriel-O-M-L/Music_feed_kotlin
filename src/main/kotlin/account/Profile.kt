package account

import java.util.*

class Profile(
    val userId: String? = UUID.randomUUID().toString(),
    val name: String? = null,
    val email: String? = null,
    val senha: String? = null
)