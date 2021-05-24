import banco.Conta
import banco.listas.Listagem
import kotlin.random.Random

class AdministraConta {

    var contasMutableList = mutableListOf<Conta>()
    var geradorDeNumerosRandomicos = Random(4665)

    fun cadastraUsuario(nome: String, senha: String): Conta {
        var novoUsuario: Conta = Conta()

        novoUsuario.userId = geradorDeNumerosRandomicos.nextInt()
        novoUsuario.nome = nome
        novoUsuario.senha = senha

        contasMutableList.add(novoUsuario)
        return novoUsuario
    }

    fun editUser(idUser: Int, senha: String) {
        var idfinderUsuario: Conta? = contasMutableList.find { it.userId == idUser }
        idfinderUsuario?.senha = senha
    }

    fun deletaUsuario(objectID: Int) {
        val idFinderUsuario: Conta? = contasMutableList.find { it.userId == objectID }
        contasMutableList.remove(idFinderUsuario)
    }

    fun gostarMusica(musicID: Int, lista: Listagem, idUser: Int) {
        var idfinderUsuario: Conta? = contasMutableList.find { it.userId == idUser }
        idfinderUsuario?.musicasMutableList?.add(musicID)
    }

    fun gostarAlbum(albumID: Int, lista: Listagem, idUser: Int) {
        var idfinderUsuario: Conta? = contasMutableList.find { it.userId == idUser }
        idfinderUsuario?.musicasMutableList?.add(albumID)
    }

    fun gostarArtista(artistaID: Int, lista: Listagem, idUser: Int) {
        var idfinderUsuario: Conta? = contasMutableList.find { it.userId == idUser }
        idfinderUsuario?.musicasMutableList?.add(artistaID)
    }

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
}
