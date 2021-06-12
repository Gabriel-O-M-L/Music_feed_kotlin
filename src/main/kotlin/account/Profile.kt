package account

import banco.listas.Listagem
import java.util.*

class Profile(
    val userId: String? = UUID.randomUUID().toString(),
    var name : String = "",
    val email: String? = null,
    var foto: String? = null,
    val senha: String? = null,
    var favorites: Listagem = Listagem()


)