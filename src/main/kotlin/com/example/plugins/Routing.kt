package com.example.plugins

import com.example.service.HelloService
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val service: HelloService by inject()

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    routing {
        get("/hello") {
            call.respondText(service.sayHello())
        }
    }
}
