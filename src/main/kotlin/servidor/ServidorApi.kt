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
import music.Artista
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
        listarArtista()
    }
}

fun Route.meuindex() {
    get("/") {
        call.respondHtml {
            body {
                h1 { +"API de Gravadora 1.0" }
                p { +"Tente chamar os outros endpoints para executar operações" }
                ul {
                    ol { +"POST - /artistas                - Criar um Artista" }
                    ol { +"POST - /artistas/album        - Cria album" }
                    ol { +"POST - /artistas/musica    - Cria musica" }
                    ol { +"GET - /artistas                - Listar todas os Artistas" }
                    ol { +"GET - /artista/Album        - Lista Album do Artista " }
                    ol { +"GET - /artista/musica        - Lista musicas do Artista " }
                }
            }
        }
    }
}

fun Route.criarArtista() {
    post("/artistas") {
        val artistaParaCriar: Artista = call.receive<Artista>()
        val artistaCriado = gravadora.cadastrarArtista(artistaParaCriar.nome!!)
        call.respond(artistaCriado)
    }
}

fun Route.listarArtista() {
    get("/artistas") {
        call.respond(gravadora.artistas)
    }
}

