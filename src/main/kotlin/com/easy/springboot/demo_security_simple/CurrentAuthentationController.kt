package com.easy.springboot.demo_security_simple

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@RestController
open class CurrentAuthentationController() {

    @GetMapping(value = ["/auth"])
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    fun auth(): Authentication? {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        // 从 Spring Security 当前 session 中获取 SPRING_SECURITY_CONTEXT
        val authentication = (request.session.getAttribute("SPRING_SECURITY_CONTEXT") as SecurityContext).authentication
        return authentication
    }

    @GetMapping(value = ["/admin"])
    @PreAuthorize("hasRole('ADMIN')")
    fun admin(): String {
        return "ADMIN"
    }

    @GetMapping(value = ["", "/", "/home"])
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    fun index(): String {
        return "HOME"
    }

    @GetMapping(value = ["/user"])
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun user(): String {
        return "USER"
    }
}
