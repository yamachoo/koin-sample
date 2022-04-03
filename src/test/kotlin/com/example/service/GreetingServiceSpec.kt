package com.example.service

import com.example.repository.GreetingRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.koin.KoinExtension
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.koin.core.context.GlobalContext
import org.koin.ksp.generated.defaultModule
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock

class GreetingServiceSpec : DescribeSpec(), KoinTest {
    init {
        val greetingService: GreetingService by inject()

        extension(KoinExtension(defaultModule) {
            mockk<GreetingRepository>()
        })

        describe("use greetingService") {
            it("return valid value") {
                declareMock<GreetingRepository> {
                    every { getGreeting() } returns "Ktor & Koin Annotations by MockK"
                }

                greetingService.sayGreeting() shouldBe "Hello Ktor & Koin Annotations by MockK!"
            }
        }

        afterSpec {
            GlobalContext.getOrNull() shouldBe null
        }
    }
}
