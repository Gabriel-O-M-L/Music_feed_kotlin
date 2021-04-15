import music.Artista
import kotlin.random.Random

class Gravadora {

    var artistas = mutableListOf<Artista>()

    fun cadastrarArtista(nome: String, nacionalidade: String): Artista {
        var artista: Artista = Artista()

        val geradorDeNumerosRandomicos = Random(4645)

        artista.id = geradorDeNumerosRandomicos.nextInt()
        artista.nome = nome
        artista.nacionalidade = nacionalidade
        artistas.add(artista)
        return artista
    }
//  fun DeleteArtista(nome: String){
//    artistas.remove(nome)
//  }
//  fun EditArtista(nome: String){

//  }

}