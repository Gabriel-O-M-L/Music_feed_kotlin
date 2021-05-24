import account.Login
import account.Profile
import banco.listas.Listagem

class AdministraConta {

    var contas = mutableListOf<Profile>()
    var objectLogin: Login = Login()

    fun cadastraUsuario(name: String, email: String, senha: String) {
        var p = Profile(name = name, email = email, senha = senha)

        objectLogin.login(email, senha, contas)
        contas.add(p)
    }


    fun editUser(idUser: Int, senha: String) {
        //TODO
    }

    fun deletaUsuario(objectID: Int) {
        //TODO
    }

    fun gostarMusica(musicID: Int, lista: Listagem, idUser: Int) {
        //TODO
    }

    fun gostarAlbum(albumID: Int, lista: Listagem, idUser: Int) {
        //TODO
    }

    fun gostarArtista(artistaID: Int, lista: Listagem, idUser: Int) {
        //TODO
    }

    /* TODO FUNCTION RECOMEND
    fun recomendMusica(idUser: Int, lista: Listagem) {
        var idfinderUsuario: Conta? = contasMutableList.find { it.userId == idUser }
        var primeiro: String? = null
        var segundo: String? = null
        var terceiro: String? = null

        idfinderUsuario?.musicasMutableList?.forEach {
            var id: Int = it
            var generoNome: String? = null
            var genero = mutableListOf<Int>()
            lista.musicasMutableList.forEach {
                if (id == it.idMusica) {
                    genero.add(id)
                    generoNome = it.genero
                } else {
                    if (generoNome == it.genero) {
                        genero.add(it.idMusica)
                    }
                }
            }
        }

    }
     */
}
