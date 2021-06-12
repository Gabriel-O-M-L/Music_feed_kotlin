package banco.lancamento

import banco.listas.Listagem
import banco.artista.Artista

abstract class Lancamento {

    var artista: Artista? = Artista()
    var duracao: String? = null
    var nome: String? = null
    var produtor: String? = null
    var genero: String? = null
    var descricao: String? = null
    var compositores: String? = null
    var link: String? = null
    var capa: String? = null
    var albumID: String? = null
    var artistaID: String? = null
}