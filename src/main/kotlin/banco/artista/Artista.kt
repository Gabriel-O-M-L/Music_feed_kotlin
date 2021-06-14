package banco.artista

import account.ControleInterface
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
import banco.listas.Listagem
import java.util.*
import kotlin.random.Random


 class Artista{

     var idArtista: String? = UUID.randomUUID().toString()
     var nacionalidade: String? = null
     var descricao: String? = null
     var link: String? = null
     var tag: String? = null
     var nome:String? = null
     var foto:String? = null



    fun criaMusica(
        artistaID: String?,
        nome: String,
        link: String,
        duracao: String,
        produtor: String,
        descricao: String,
        albumID: String?,
        lista: Listagem
    ): Musica {
        val musica: Musica = Musica()

        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == albumID }
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        musica.artista = idFinderArtista
        musica.descricao = descricao
        musica.duracao = duracao
        musica.produtor = produtor
        musica.album = idFinderAlbum
        musica.nome = nome
        musica.link = link
        musica.idMusica = UUID.randomUUID().toString()

        lista.musicasMutableList.add(musica)
        return musica
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
        artistaID: String?,
        lista: Listagem
    ): Album {
        val album: Album = Album()

        val idFinder: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        album.artista = idFinder
        album.link = link
        album.nome = nome
        album.genero = genero
        album.duracao = duracao
        album.produtor = produtor
        album.compositores = compositores
        album.descricao = descricao
        album.capa = capa
        album.idAlbum = UUID.randomUUID().toString()

        lista.albunsMutableList.add(album)
        return album
    }

    fun editarAlbum(
        nome: String,
        link: String,
        editID: String?,
        objectID: String?,
        genero: String,
        descricao: String,
        compositores: String,
        lista: Listagem,
        duracao: String,
        produtor: String,
        capa: String
    ) {
        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == objectID }
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == editID }

        idFinderAlbum?.artista = idFinderArtista
        idFinderAlbum?.nome = nome
        idFinderAlbum?.link = link
        idFinderAlbum?.compositores = compositores
        idFinderAlbum?.genero = genero
        idFinderAlbum?.descricao = descricao
        idFinderAlbum?.produtor = produtor
        idFinderAlbum?.duracao = duracao
        idFinderAlbum?.capa = capa
    }

    fun editarMusica(nome: String, link: String, editID: String?, objectID: String?, genero: String, descricao: String, compositores: String, lista: Listagem, duracao: String, produtor: String, capa: String) {
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

    fun deleteAlbum(objectID: String?, lista: Listagem) {
        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == objectID }
        lista.albunsMutableList.remove(idFinderAlbum)
    }

    fun deleteMusica(objectID: String?, lista: Listagem) {
        val idFinderMusica: Musica? = lista.musicasMutableList.find { it.idMusica == objectID }
        lista.musicasMutableList.remove(idFinderMusica)
    }

}
