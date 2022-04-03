package com.example.repository

import org.koin.core.annotation.Single

@Single
class GreetingRepository {
    fun getGreeting(): String = "Ktor & Koin Annotations"
}
