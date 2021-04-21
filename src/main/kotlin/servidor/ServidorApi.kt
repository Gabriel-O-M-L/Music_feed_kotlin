package servidor

import Gravadora
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
<<<<<<< Updated upstream
import music.Artista
=======
<<<<<<< Updated upstream
import music.Artista
=======
import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
>>>>>>> Stashed changes
>>>>>>> Stashed changes
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val gravadora = Gravadora()

/**
 * Configura um módulo do servidor. Cada módulo pode ter vários endpoints (endereços) e podem ser
 * "anexados" ao servidor pelas configurações do arquivo "application.conf" na pasta RESOURCES do
 * projeto.
 */
@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.Gravadora(testing: Boolean = false) {
    /**
     * Configura o servidor para "imprimir" no log as mensagens e textos do servidor
     */
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    /**
     * Configura o servidor para "entender" Json e converter para um objeto (instância de uma classe)
     */
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    /**
     * Configura as rotas do servidor, ou seja, os endpoints ou endereços disponíveis para cada
     * operação no servidor
     */
    routing {
        meuindex()
        criarArtista()
<<<<<<< Updated upstream
        listarArtista()
=======
<<<<<<< Updated upstream
        listarArtista()
=======
        criarAlbum()
        criarMusica()
        editarArtista()
        editarAlbum()
        editarMusica()
        deletarArtista()
        deletarAlbum()
        deletarMusica()
        listarArtista()
        listarAlbum()
        listarMusica()
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }
}

fun Route.meuindex() {
    get("/") {
        call.respondHtml {
            body {
                h1 { +"API de Gravadora 1.0" }
                p { +"Tente chamar os outros endpoints para executar operações" }
                ul {
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
                    ol { +"POST - /artistas                - Criar um Artista" }
                    ol { +"POST - /artistas/album        - Cria album" }
                    ol { +"POST - /artistas/musica    - Cria musica" }
                    ol { +"GET - /artistas                - Listar todas os Artistas" }
                    ol { +"GET - /artista/Album        - Lista Album do Artista " }
                    ol { +"GET - /artista/musica        - Lista musicas do Artista " }
<<<<<<< Updated upstream
=======
=======
                    ol { +"POST - /artista/criar                  - Criar Artista" }
                    ol { +"POST - /album/criar                     - Criar Album" }
                    ol { +"POST - /musica/criar                    - Criar Musica" }
                    ol { +"PATCH - /artista/editar                - Editar Artista" }
                    ol { +"PATCH - /album/editar                   - Editar Album" }
                    ol { +"PATCH - /musica/editar                  - Editar Musica" }
                    ol { +"DELETE - /artista/deletar              - Deletar Artista" }
                    ol { +"DELETE - /album/deletar                 - Deletar Album" }
                    ol { +"DELETE - /musica/deletar                - Deletar Musica" }
                    ol { +"GET - /artista/listar                  - Listar Artista" }
                    ol { +"GET - /album/listar                     - Listar Album" }
                    ol { +"GET - /musica/listar                   - Listar Musica" }
>>>>>>> Stashed changes
>>>>>>> Stashed changes
                }
            }
        }
    }
}

fun Route.criarArtista() {
<<<<<<< Updated upstream
    post("/artistas") {
        val artistaParaCriar: Artista = call.receive<Artista>()
        val artistaCriado = gravadora.cadastrarArtista(artistaParaCriar.nome!!)
=======
<<<<<<< Updated upstream
    post("/artistas") {
        val artistaParaCriar: Artista = call.receive<Artista>()
        val artistaCriado = gravadora.cadastrarArtista(artistaParaCriar.nome!!)
=======
    post("/artista/criar") {
        val artistaParaCriar: Artista = call.receive<Artista>()
        val artistaCriado = gravadora.cadastrarArtista(
            artistaParaCriar.nome!!,
            artistaParaCriar.nacionalidade!!,
            artistaParaCriar.foto!!,
            artistaParaCriar.descricao!!,
            artistaParaCriar.link!!
        )
>>>>>>> Stashed changes
>>>>>>> Stashed changes
        call.respond(artistaCriado)
    }
}

<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
fun Route.listarArtista() {
    get("/artistas") {
        call.respond(gravadora.artistas)
    }
}

<<<<<<< Updated upstream
=======
=======
fun Route.criarAlbum() {
    post("/album/criar") {
        val albumParaCriar: Album = call.receive<Album>()
        val albumCriado = gravadora.criarAlbum(
            albumParaCriar.nome!!,
            albumParaCriar.link!!,
            albumParaCriar.genero!!,
            albumParaCriar.duracao!!,
            albumParaCriar.produtor!!,
            albumParaCriar.compositores!!,
            albumParaCriar.descricao!!,
            albumParaCriar.capa!!,
            albumParaCriar.artistaID!!
        )
        call.respond(albumCriado)
    }
}

fun Route.criarMusica() {
    post("/musica/criar") {
        val musicaParaCriar: Musica = call.receive<Musica>()
        val musicaCriada = gravadora.criaMusica(
            musicaParaCriar.artistaID!!,
            musicaParaCriar.nome!!,
            musicaParaCriar.link!!,
            musicaParaCriar.duracao!!,
            musicaParaCriar.produtor!!,
            musicaParaCriar.descricao!!,
            musicaParaCriar.albumID!!
        )
        call.respond(musicaCriada)
    }
}

fun Route.editarArtista() {
    patch("/artista/editar") {
        val artistaParaEditar: Artista = call.receive<Artista>()
        val artistaEditado = gravadora.editArtista(
            artistaParaEditar.nome!!,
            artistaParaEditar.idArtista!!,
            artistaParaEditar.nacionalidade!!,
            artistaParaEditar.descricao!!,
            artistaParaEditar.foto!!,
            artistaParaEditar.link!!
        )
        call.respond(artistaEditado)
    }
}

fun Route.editarAlbum() {
    patch("/album/editar") {
        val albumParaEditar: Album = call.receive<Album>()
        val albumEditado = gravadora.editAlbum(
            albumParaEditar.nome!!,
            albumParaEditar.link!!,
            albumParaEditar.artistaID!!,
            albumParaEditar.albumID!!,
            albumParaEditar.genero!!,
            albumParaEditar.descricao!!,
            albumParaEditar.compositores!!,
            albumParaEditar.duracao!!,
            albumParaEditar.produtor!!,
            albumParaEditar.capa!!
        )
        call.respond(albumEditado)
    }
}

fun Route.editarMusica() {
    patch("/musica/editar") {
        val musicaParaEditar: Musica = call.receive<Musica>()
        val musicaEditada = gravadora.editMusica(
            musicaParaEditar.nome!!,
            musicaParaEditar.link!!,
            musicaParaEditar.idMusica!!,
            musicaParaEditar.albumID!!,
            musicaParaEditar.genero!!,
            musicaParaEditar.descricao!!,
            musicaParaEditar.compositores!!,
            musicaParaEditar.duracao!!,
            musicaParaEditar.produtor!!,
            musicaParaEditar.capa!!
        )
        call.respond(musicaEditada)
    }
}

fun Route.deletarArtista() {
    delete("/artista/deletar") {
        val artistaParaDeletar: Artista = call.receive<Artista>()
        val artistaDeletado = gravadora.deleteArtista(
            artistaParaDeletar.idArtista!!
        )
        call.respond(artistaDeletado)
    }
}

fun Route.deletarAlbum() {
    delete("/album/deletar") {
        val albumParaDeletar: Album = call.receive<Album>()
        val albumDeletado = gravadora.deleteAlbum(
            albumParaDeletar.idAlbum!!
        )
        call.respond(albumDeletado)
    }
}

fun Route.deletarMusica() {
    delete("/musica/deletar") {
        val musicaParaDeletar: Musica = call.receive<Musica>()
        val musicaDeletada = gravadora.deleteMusica(
            musicaParaDeletar.idMusica!!
        )
        call.respond(musicaDeletada)
    }
}

fun Route.listarAlbum() {
    get("/album/listar") {
        call.respond(gravadora.lista.albunsMutableList)
    }
}

fun Route.listarArtista() {
    get("/artista/listar") {
        call.respond(gravadora.lista.artistasMutableList)
    }
}

fun Route.listarMusica() {
    get("/musica/listar") {
        call.respond(gravadora.lista.musicasMutableList)
    }
}
>>>>>>> Stashed changes
>>>>>>> Stashed changes
