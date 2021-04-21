package servidor

import Gravadora
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.netty.*
import kotlinx.html.body
import kotlinx.html.h1
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = EngineMain.main(args)

/**
 * Configura um módulo do servidor. Cada módulo pode ter vários endpoints (endereços) e podem ser
 * "anexados" ao servidor pelas configurações do arquivo "application.conf" na pasta RESOURCES do
 * projeto.
 */
@Suppress("unused")
@JvmOverloads
fun Application.module(testing: Boolean = false) {

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
        index()
        adicionarGravadora()
    }

}

fun Route.index() {
    get {
        call.respondHtml {
            body {
                h1 {
                    +"Hello World!!!!!"
                }
            }
        }
    }
}

fun Route.adicionarGravadora() {
    post("Gravadora/add") {
        val gravadora = call.receive<Gravadora>()
        println(gravadora)
    }
}