package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.response.LoginResponse
import com.sorsix.barmanagmentapi.config.jwt.JwtUtil
import com.sorsix.barmanagmentapi.dto.LoginDTO
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.AuthService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
class AuthController(
    val authService: AuthService,
    val authManager: AuthenticationManager,
    val jwtToken: JwtUtil
) {
    val logger: Logger = LoggerFactory.getLogger(AuthController::class.java)

    @PostMapping("/register")
    fun createUser(
        @RequestBody @Valid registerDto: RegisterDTO,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        this.authService.registerUser(registerDto)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginDTO): ResponseEntity<LoginResponse> {
        val auth = this.authManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val user = authService.loadUserByUsername(request.email)!!
        val jwt = jwtToken.generateJwtToken(auth)

        logger.info("User logged in ${user.email}")
        return ResponseEntity.ok(LoginResponse(jwt, user.id, user.email, user.name))
    }
}