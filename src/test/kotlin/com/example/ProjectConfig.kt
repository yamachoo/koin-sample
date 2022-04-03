package com.example

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.koin.KoinExtension
import org.koin.ksp.generated.defaultModule

object ProjectConfig : AbstractProjectConfig() {
    override fun extensions() = listOf(KoinExtension(defaultModule))
}
