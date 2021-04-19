package Banco

class Album: Lancamento(){

    var idAlbum: Int? = null

    override fun editar(nome: String, link: String,editID: Int,objectID: Int,genero: String,descricao: String,compositores: String, lista: Listagem, duracao: String, produtor: String,capa: String) {
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


}