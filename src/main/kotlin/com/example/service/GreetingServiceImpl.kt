package com.example.service

import com.example.repository.GreetingRepository
import org.koin.core.annotation.Single

@Single
class GreetingServiceImpl(private val greetingRepository: GreetingRepository) : GreetingService {
    override fun sayGreeting() = "Hello ${greetingRepository.getGreeting()}!"
}
