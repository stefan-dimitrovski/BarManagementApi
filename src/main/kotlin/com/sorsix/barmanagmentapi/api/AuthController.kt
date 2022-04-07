package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.LoginDTO
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController(private val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User(
            name = body.name,
            email = body.email
        )

        user.password = body.password

        return ResponseEntity.ok(this.userService.saveUser(user))
    }

    @PostMapping("/login")
    fun login(@RequestBody body: LoginDTO): ResponseEntity<Any> =
        this.userService.findUserByEmail(body.email)?.let {
            if (!it.comparePassword(body.password)) {
                ResponseEntity.badRequest().body("Incorrect password")
            } else {
                ResponseEntity.ok(it)
            }
        } ?: ResponseEntity.badRequest().body("User with email ${body.email} not found!")
}