package com.example

import com.example.module.helloAppModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import org.koin.ksp.generated.defaultModule
import org.koin.ktor.ext.Koin
import org.koin.logger.SLF4JLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(DefaultHeaders)
        install(CallLogging)
        install(Koin) {
            SLF4JLogger()
            modules(helloAppModule)
            defaultModule()
        }

        configureRouting()
    }.start(wait = true)
}
