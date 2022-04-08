package com.sorsix.barmanagmentapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class BarManagementApiApplication

fun main(args: Array<String>) {
    runApplication<BarManagementApiApplication>(*args)

}


