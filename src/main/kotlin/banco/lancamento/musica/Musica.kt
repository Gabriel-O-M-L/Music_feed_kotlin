package banco.lancamento.musica

import banco.listas.Listagem
import banco.lancamento.Lancamento
import banco.lancamento.album.Album
import java.util.*


class Musica : Lancamento() {

    //var idMusica: Int? = null
    var idMusica: String? = UUID.randomUUID().toString()
    var album: Album? = Album()

}