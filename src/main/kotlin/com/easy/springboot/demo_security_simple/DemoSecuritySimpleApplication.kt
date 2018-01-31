package com.easy.springboot.demo_security_simple

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class])
open class DemoSecuritySimpleApplication

fun main(args: Array<String>) {
    runApplication<DemoSecuritySimpleApplication>(*args)
}
