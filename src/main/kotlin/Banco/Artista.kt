package Banco


open class Artista {

    var nome: String? = null
    var idArtista: Int? = null
    var nacionalidade: String? = null
    var descricao: String? = null
    var foto: String? = null
    var link: String? = null



    fun edit(nome: String,link: String,artistaID: Int,nacionalidade: String,descricao: String,foto: String,lista: Listagem) {
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        idFinderArtista?.nacionalidade = nacionalidade
        idFinderArtista?.nome = nome
        idFinderArtista?.link = link
        idFinderArtista?.descricao = descricao
        idFinderArtista?.foto = foto
    }
}
