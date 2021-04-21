package banco.listas

import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica

open class Listagem {

    var artistasMutableList = mutableListOf<Artista>()
    var musicasMutableList = mutableListOf<Musica>()
    var albunsMutableList = mutableListOf<Album>()

}