package banco.lancamento.musica

import banco.listas.Listagem
import banco.lancamento.Lancamento
import banco.lancamento.album.Album


class Musica : Lancamento() {

    var idMusica: Int? = null
    var album: Album? = Album()


    override fun editar(nome: String, link: String, editID: Int, objectID: Int, genero: String, descricao: String, compositores: String, lista: Listagem, duracao: String, produtor: String, capa: String) {
        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == editID }
        val idFinderMusica: Musica? = lista.musicasMutableList.find { it.idMusica == objectID }

        idFinderMusica?.artista = idFinderAlbum?.artista
        idFinderMusica?.album = idFinderAlbum
        idFinderMusica?.nome = nome
        idFinderMusica?.link = link
        idFinderMusica?.compositores = compositores
        idFinderMusica?.genero = genero
        idFinderMusica?.descricao = descricao
        idFinderMusica?.capa = capa
    }


}