package Banco

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

    abstract fun editar(nome: String, link: String,editID: Int,objectID: Int,genero: String,descricao: String,compositores: String,lista: Listagem,duracao: String, produtor: String, capa: String)
}