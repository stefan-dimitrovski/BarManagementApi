package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.response.LoginResponse
import com.sorsix.barmanagmentapi.config.jwt.JwtUtil
import com.sorsix.barmanagmentapi.dto.LoginDTO
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.AuthService
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

    @PostMapping("/register")
    fun registerUser(
        @RequestBody @Valid registerDto: RegisterDTO,
        request: HttpServletRequest
    ): ResponseEntity<Any> {

        val result = this.authService.createUser(registerDto)

        result?.let {
            return ResponseEntity.ok().build()
        } ?: return ResponseEntity.badRequest().body("User with that email already exists")
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody loginDTO: LoginDTO): ResponseEntity<Any> {

        val user = authService.loadUserByUsername(loginDTO.email)

        user?.let {
            val auth = this.authManager.authenticate(
                UsernamePasswordAuthenticationToken(loginDTO.email, loginDTO.password)
            )
            val jwt = jwtToken.generateJwtToken(auth)

            return ResponseEntity.ok(LoginResponse(jwt, user.id, user.email, user.name, user.role, user.worksInLocale))
        } ?: return ResponseEntity.badRequest().body("User does not exist")
    }
}
