package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.response.LoginResponse
import com.sorsix.barmanagmentapi.config.utils.JwtUtils
import com.sorsix.barmanagmentapi.dto.LoginDTO
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.UserService
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
@RequestMapping("/api")
@CrossOrigin
class AuthController(
    val userService: UserService,
    val authManager: AuthenticationManager,
    val jwtToken: JwtUtils
) {

    @PostMapping("/register")
    fun createUser(
        @RequestBody @Valid registerDto: RegisterDTO,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        this.userService.save(registerDto)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginDTO): ResponseEntity<LoginResponse> {
        val auth = this.authManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val user = userService.loadUserByUsername(request.email)!!
        val jwt = jwtToken.generateJwtToken(auth)
        return ResponseEntity.ok(LoginResponse(jwt, user.id, user.email, user.name))
    }
}