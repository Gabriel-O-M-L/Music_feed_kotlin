package account

class Login {
    var currentProfile: Profile? = null


    fun login(email: String, senha: String, contas: MutableList<Profile>): Boolean{
        currentProfile = contas.firstOrNull {p -> p.email == email && p.senha == senha}
        return currentProfile != null
    }

}