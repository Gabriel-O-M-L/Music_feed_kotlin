package servidor

import Gravadora
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import account.Profile
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import banco.artista.Artista
import banco.lancamento.album.Album
import banco.lancamento.musica.Musica
import io.ktor.http.*
import org.slf4j.event.Level
import java.rmi.ServerError

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
        profile()
        criarArtista()
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
        buscarArtista()
        buscarMusica()
        buscarAlbum()
        editarInterfaceArtista()
        editarInterfaceUsuario()
    }
}

fun Route.meuindex() {
    get("/") {
        call.respondHtml {
            body {
                h1 { +"API de Gravadora 1.0" }
                p { +"Tente chamar os outros endpoints para executar operações" }
                ul {
                    ol { +"POST - /profile                   - Cria um usuario" }
                    ol { +"GET - /profile                   - Confere se um Usuario foi encontado" }
                    ol { +"POST - /login                   - Entra em um usuario" }
                    ol { +"PATCH - /editar/interfaceUsuario         - Edita Aspectos visuais de um usuario" }
                    ol { +"POST - /artista/criar                  - Criar Artista" }
                    ol { +"POST - /album/criar                     - Criar Album" }
                    ol { +"POST - /musica/criar                    - Criar Musica" }
                    ol { +"PATCH - /artista/editar                - Editar Artista" }
                    ol { +"PATCH - /editar/interfaceArtista         - Edita Aspectos visuais de um artista" }
                    ol { +"PATCH - /album/editar                   - Editar Album" }
                    ol { +"PATCH - /musica/editar                  - Editar Musica" }
                    ol { +"DELETE - /artista/deletar              - Deletar Artista" }
                    ol { +"DELETE - /album/deletar                 - Deletar Album" }
                    ol { +"DELETE - /musica/deletar                - Deletar Musica" }
                    ol { +"GET - /artista/listar                  - Listar Artista" }
                    ol { +"GET - /album/listar                     - Listar Album" }
                    ol { +"GET - /musica/listar                   - Listar Musica" }
                    ol { +"POST - /artista/buscar                   - Buscar Artista" }
                    ol { +"POST - /album/buscar                   -  Buscar Album" }
                    ol { +"POST - /musica/buscar                   - Buscar Musica" }
                }
            }
        }
    }
}

fun Route.profile() {
    get("/profile") {
        val user = gravadora.currentProfile
        if (user == null) {
            val error = ServerError(HttpStatusCode.NotFound.value, "Usuário não encontrado")
            call.respond(HttpStatusCode.NotFound, error)
        } else {
            call.respond(HttpStatusCode.OK, user)
        }
    }

    post("/profile") {
        val customer = call.receive<Profile>()

        // Verifica se o e-mail foi envidado na requisição
        if (customer.email == null) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "O E-MAIL é obrigatório para o cadastro!")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        if (customer.name == null) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "O NOME é obrigatório para o cadastro!")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        if (customer.senha == null) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "A SENHA é obrigatório para o cadastro!")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        gravadora.cadastraUsuarios(customer.name, customer.email, customer.senha)
        call.respond(HttpStatusCode.Created)
    }

    post("/login") {
        val customer = call.receive<Profile>()
        // Verifica se o e-mail foi envidado na requisição
        if (customer.email == null) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "O E-MAIL é obrigatório efetuar login!")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        if (customer.senha == null) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "A SENHA é obrigatório efetuar login!")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        val result = gravadora.login(customer.email, customer.senha)
        if (!result) {
            val error = ServerError(HttpStatusCode.BadRequest.value, "Não foi possível efetuar login. Por favor verifique os dados.")
            call.respond(HttpStatusCode.BadRequest, error)
            return@post
        }

        call.respond(HttpStatusCode.NoContent)
    }

}



fun Route.criarArtista() {
    post("/artista/criar") {
        val artistaParaCriar: Artista = call.receive<Artista>()
        val artistaCriado = gravadora.cadastrarArtista(
            artistaParaCriar.nome!!,
            artistaParaCriar.nacionalidade!!,
            artistaParaCriar.foto!!,
            artistaParaCriar.tag!!,
            artistaParaCriar.descricao!!,
            artistaParaCriar.link!!
        )
        call.respond(artistaCriado)
    }
}

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
            artistaParaEditar.link!!,
            artistaParaEditar.idArtista!!,
            artistaParaEditar.nacionalidade!!,
            artistaParaEditar.descricao!!,
            artistaParaEditar.tag!!
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

fun Route.buscarArtista() {
    post("/artista/buscar"){
        val buscandoArtista : Artista = call.receive<Artista>()
        val artistaEncontrado = gravadora.buscarArtista(
            buscandoArtista.nome!!
        )
        call.respond(artistaEncontrado)
    }
}
fun Route.buscarMusica() {
    post("/musica/buscar"){
        val buscandoMusica : Musica = call.receive<Musica>()
        val musicaEncontrada = gravadora.buscarMusica(
            buscandoMusica.nome!!
        )
        call.respond(musicaEncontrada)
    }
}
fun Route.buscarAlbum() {
    post("/album/buscar"){
        val buscandoAlbum : Album = call.receive<Album>()
        val albumEncontrado = gravadora.buscarAlbum(
            buscandoAlbum.nome!!
        )
        call.respond(albumEncontrado)
    }
}
fun Route.editarInterfaceArtista()
{
    patch("/editar/interfaceArtista"){
        val artistaParaEditar: Artista = call.receive<Artista>()
        val artistaEditada = gravadora.editarInterface(
            artistaParaEditar.nome!!,
            artistaParaEditar.foto!!,
            artistaParaEditar.idArtista!!
        )
    }
}
fun Route.editarInterfaceUsuario(){
    patch("/editar/interfaceUsuario"){
        val usuarioParaEditar: Profile = call.receive<Profile>()
        val usuarioEditada = gravadora.editarInterfaceUsuario(
            usuarioParaEditar.name!!,
            usuarioParaEditar.foto!!,
            usuarioParaEditar.userId!!
        )
    }
 }
