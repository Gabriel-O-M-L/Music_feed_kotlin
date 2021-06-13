import account.ControleInterface
import account.Profile
import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
import banco.listas.Listagem
import java.util.*
import kotlin.random.Random

class Gravadora: ControleInterface() {

    var lista: Listagem = Listagem()
    var objectArtista: Artista = Artista()
    var geradorDeNumerosRandomicos: String? = UUID.randomUUID().toString()
    var currentProfile: Profile? = null
    var administraContas: AdministraConta = AdministraConta()


    fun login(email: String, senha: String): Boolean {
        currentProfile = administraContas.contas.firstOrNull { p -> p.email == email && p.senha == senha }
        return currentProfile != null
    }

    fun cadastraUsuarios(name: String, email: String, senha: String) {
        administraContas.cadastraUsuario(name, email, senha)
    }

    fun editarInterfaceUsuario(nome: String, foto: String,id: String){
        administraContas.editarInterface(nome, foto, id)
    }


    fun cadastrarArtista(
        nome: String,
        nacionalidade: String,
        foto: String,
        tag: String,
        descricao: String,
        link: String
    ): Artista {
        val artista: Artista = Artista()

        artista.foto = foto
        artista.idArtista = geradorDeNumerosRandomicos
        artista.nome = nome
        artista.nacionalidade = nacionalidade
        artista.descricao = descricao
        artista.link = link
        artista.tag = tag
        lista.artistasMutableList.add(artista)
        return artista
    }

    fun criaMusica(
        artistaID: String?,
        nome: String,
        link: String,
        duracao: String,
        produtor: String,
        descricao: String,
        albumID: String?
    ) {
        objectArtista.criaMusica(artistaID, nome, link, duracao, produtor, descricao, albumID, lista)
    }

    fun criarAlbum(
        nome: String,
        link: String,
        genero: String,
        duracao: String,
        produtor: String,
        compositores: String,
        descricao: String,
        capa: String,
        artistaID: String?
    ) {
        objectArtista.criarAlbum(nome, link, genero, duracao, produtor, compositores, descricao, capa, artistaID, lista)
    }

    fun editArtista(link: String, artistaID: String, nacionalidade: String, descricao: String, tag: String) {
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        idFinderArtista?.nacionalidade = nacionalidade
        idFinderArtista?.link = link
        idFinderArtista?.descricao = descricao
        idFinderArtista?.tag = tag
    }

    override fun editarInterface(nome: String, foto: String,id: String ) {
        val idFinderControleInterface: Artista? = lista.artistasMutableList.find { it.idArtista == id }

        idFinderControleInterface?.nome = nome
        idFinderControleInterface?.foto = foto
    }

    fun editAlbum(
        nome: String,
        link: String,
        editID: String?,
        objectID: String?,
        genero: String,
        descricao: String,
        compositores: String,
        duracao: String,
        produtor: String,
        capa: String
    ) {
        objectArtista.editarAlbum(
            nome,
            link,
            editID,
            objectID,
            genero,
            descricao,
            compositores,
            lista,
            duracao,
            produtor,
            capa
        )
    }

    fun editMusica(
        nome: String,
        link: String,
        editID: String?,
        objectID: String?,
        genero: String,
        descricao: String,
        compositores: String,
        duracao: String,
        produtor: String,
        capa: String
    ) {
        objectArtista.editarMusica(
            nome,
            link,
            editID,
            objectID,
            genero,
            descricao,
            compositores,
            lista,
            duracao,
            produtor,
            capa
        )
    }

    fun deleteArtista(objectID: String?) {
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == objectID }
        lista.artistasMutableList.remove(idFinderArtista)
    }

    fun deleteAlbum(objectID: String?) {
        objectArtista.deleteAlbum(objectID, lista)
    }

    fun deleteMusica(objectID: String?) {
        objectArtista.deleteMusica(objectID, lista)
    }

    fun gostaMusica(findMusica: String) {
        administraContas.gostarMusica(findMusica, lista, currentProfile)
    }

    fun gostaAlbum(findAlbum: String) {
        administraContas.gostarAlbum(findAlbum, lista, currentProfile)
    }

    fun gostaArtista(findArtista: String) {
        administraContas.gostarMusica(findArtista, lista, currentProfile)
    }

    fun buscarMusica(nome: String): List<Musica> {
        return lista.musicasMutableList.filter { it.nome == nome }
    }

    fun buscarAlbum(nome: String): List<Album> {
        return lista.albunsMutableList.filter { it.nome == nome }
    }

    fun buscarArtista(nome: String): List<Artista> {
        return lista.artistasMutableList.filter { it.nome == nome }
    }
}
