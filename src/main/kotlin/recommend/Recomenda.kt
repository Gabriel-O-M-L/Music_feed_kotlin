package recommend

import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
import banco.listas.Listagem

class Recomenda {

    fun recomendaArtista(favorites: Listagem, lista: Listagem): List<Artista> {
        var quantidadeTemp: Int
        var quantidade: Int = 0
        var nomeTag: String = ""
        var item: Int = 0
        var iter = favorites.artistasMutableList.listIterator()
        while(iter.hasNext()) {
            item++
            if (item == 1) {
                quantidade =
                    favorites.artistasMutableList.count { it.tag == favorites.artistasMutableList.get(item).tag }
                nomeTag = favorites.artistasMutableList.get(item).tag!!
            }
        }
        quantidadeTemp = favorites.artistasMutableList.count{it.tag == favorites.artistasMutableList.get(item).tag}

        if (quantidadeTemp > quantidade){
            quantidade = quantidadeTemp
            nomeTag = favorites.artistasMutableList.get(item).tag!!
        }

        var listaFiltrada : List<Artista> = lista.artistasMutableList.filter { it.tag == nomeTag}
        return listaFiltrada
    }
        fun recomendaAlbum(favorites: Listagem, lista: Listagem): List<Album> {
            var quantidadeTemp: Int
            var quantidade: Int = 0
            var nomeGenero: String = ""
            var item: Int = 0
            var iter = favorites.albunsMutableList.listIterator()
            while(iter.hasNext()) {
                item++
                if(item == 1){
                    quantidade = favorites.albunsMutableList.count{it.genero == favorites.albunsMutableList.get(item).genero}
                    nomeGenero = favorites.albunsMutableList.get(item).genero!!
                }

            }
            quantidadeTemp = favorites.albunsMutableList.count{it.genero == favorites.albunsMutableList.get(item).genero}

            if (quantidadeTemp > quantidade){
                quantidade = quantidadeTemp
                nomeGenero = favorites.albunsMutableList.get(item).genero!!
            }

        var listaFiltrada : List<Album> = lista.albunsMutableList.filter { it.genero == nomeGenero }
        return listaFiltrada
    }

    fun recomendaMusica(favorites: Listagem, lista: Listagem): List<Musica> {
        var quantidadeTemp: Int
        var quantidade: Int = 0
        var nomeGenero: String = ""
        var item: Int = 0
        var iter = favorites.musicasMutableList.listIterator()
        while(iter.hasNext()) {
            item++
            if(item == 1){
                quantidade = favorites.musicasMutableList.count{it.genero == favorites.musicasMutableList.get(item).genero}
                nomeGenero = favorites.musicasMutableList.get(item).genero!!
            }
            quantidadeTemp = favorites.musicasMutableList.count{it.genero == favorites.musicasMutableList.get(item).genero}

            if (quantidadeTemp > quantidade){
                quantidade = quantidadeTemp
                nomeGenero = favorites.musicasMutableList.get(item).genero!!
            }
        }
        var listaFiltrada : List<Musica> = lista.musicasMutableList.filter { it.genero == nomeGenero }
        return listaFiltrada
    }


}