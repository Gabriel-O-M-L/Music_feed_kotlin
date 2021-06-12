import account.ControleInterface
import account.Profile
import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
import banco.listas.Listagem
import recommend.Recomenda

class AdministraConta: ControleInterface() {

    var recomendados : Recomenda = Recomenda()
    var contas = mutableListOf<Profile>()

    fun cadastraUsuario(name: String, email: String, senha: String) {
        var p = Profile(name = name, email = email, senha = senha)

        contas.add(p)
    }

    fun gostarMusica(findMusica: String, lista: Listagem, currentProfile: Profile?) {
        val finder: Musica? = lista.musicasMutableList.find { it.nome == findMusica }
        currentProfile!!.favorites.musicasMutableList.add(finder!!)
        recomendados.recomendaMusica(currentProfile.favorites,lista)
    }

    fun gostarAlbum(findAlbum: String, lista: Listagem, currentProfile: Profile?) {
        val finder: Album? = lista.albunsMutableList.find { it.nome == findAlbum }
        currentProfile!!.favorites.albunsMutableList.add(finder!!)
        recomendados.recomendaAlbum(currentProfile.favorites,lista)
    }

    fun gostarArtista(findNome: String, lista: Listagem, currentProfile: Profile?) {
        val finder: Artista? = lista.artistasMutableList.find { it.nome == findNome }
        currentProfile!!.favorites.artistasMutableList.add(finder!!)
        recomendados.recomendaArtista(currentProfile.favorites,lista)
    }

    override fun editarInterface(nome: String, foto: String, id : String) {
        val idFinderControleInterface: Profile? = contas.find { it.userId == id }

        idFinderControleInterface?.name = nome
        idFinderControleInterface?.foto = foto
    }
}

