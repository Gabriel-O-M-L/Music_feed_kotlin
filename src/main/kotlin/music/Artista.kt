package music


open class Artista {

    var nome: String? = null
    var albuns = mutableListOf<Album>()
    var musicas = mutableListOf<Musica>()
    var id: Int? = null
    var nacionalidade: String? = null

    fun criarMusica(nome: String, link: String): Musica {
        var musica: Musica = Musica()

        musica.nome = nome
        musica.link = link

        musicas.add(musica)
        return musica
    }

    fun criarAlbum(nome: String, genero: String, musica: Musica): Album {
        var album: Album = Album()

        album.nome = nome
        album.genero = genero
        album.musicas = musicas

        albuns.add(album)
        return album
    }

}