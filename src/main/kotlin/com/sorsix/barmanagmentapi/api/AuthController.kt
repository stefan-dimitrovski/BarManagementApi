package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.LoginDTO
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class AuthController(private val userService: UserService) {

    private val secret =
        "secretsafljfasdlkfjasdflkjsdaflsafsdafsdfahasdfhasdfhjsdfghjfasdhgjasdfhgjasdfghjasdfgjasd" +
                "fghjasghjdfasfghjdasfghjdghjasfdghjasdfghjasdfghasdfghsdfaghasfdghjasdfghjasdfghj"

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
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> =
        this.userService.findUserByEmail(body.email)?.let {
            if (!it.comparePassword(body.password)) {
                ResponseEntity.badRequest().body("Incorrect password")
            } else {
                // TODO: IMPROVE THIS
                val issuer = it.id.toString()
                val jwt =
                    Jwts.builder()
                        .setIssuer(issuer)
                        .setExpiration(Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                        .signWith(
                            SignatureAlgorithm.HS512,
                            secret
                        )
                        .compact()

                val cookie = Cookie("jwt", jwt)
                cookie.isHttpOnly = true

                response.addCookie(cookie)

                ResponseEntity.ok("Success")
            }
        } ?: ResponseEntity.badRequest().body("User with email ${body.email} not found!")

    @GetMapping("/user")
    fun getCurrentUser(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> =
        // TODO: IMPROVE THIS
        try {
            jwt?.let {
                val body = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).body
                ResponseEntity.ok(this.userService.getUserById(body.issuer.toLong()))
            } ?: ResponseEntity.status(401).body("User not authenticated!")
        } catch (e: Exception) {
            ResponseEntity.status(401).body("User not authenticated!")
        }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok("Success Logout")
    }
}
