package com.example.service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.koin.test.KoinTest
import org.koin.test.inject

class GreetingServiceSpec : DescribeSpec(), KoinTest {
    private val greetingService: GreetingService by inject()

    init {
        describe("use greetingService") {
            it("return valid value") {
                greetingService.sayGreeting() shouldBe "Hello Ktor & Koin Annotations!"
            }
        }
    }
}
