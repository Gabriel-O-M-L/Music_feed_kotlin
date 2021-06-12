package banco.lancamento.album

import banco.listas.Listagem
import banco.artista.Artista
import banco.lancamento.Lancamento
import java.util.*


class Album : Lancamento() {

    //var idAlbum: Int? = null
    var idAlbum: String? = UUID.randomUUID().toString()
}