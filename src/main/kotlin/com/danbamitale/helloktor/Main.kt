package com.danbamitale.helloktor

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun main(args: Array<String>){
    embeddedServer(Netty, 8080, module = Application::mainModule).start(true)
}

fun Application.mainModule(){
    println("Starting up server")
    routing {
        println("Setting up routes")
        root()
    }
}

fun Routing.root(){
    get ("/"){
        call.respond(HttpStatusCode.OK,  "Hello World Ktor")
    }

    post("/"){
        call.respond(HttpStatusCode.Forbidden, "Request not permitted")
    }
}