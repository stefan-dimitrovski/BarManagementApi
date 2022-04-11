package com.sorsix.barmanagmentapi.config

import com.sorsix.barmanagmentapi.domain.exceptions.InvalidCredentialsException
import com.sorsix.barmanagmentapi.domain.exceptions.UserNotFoundException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class UnauthorizedAuthenticationEntryPoint : BasicAuthenticationEntryPoint() {

    @Throws(
        IOException::class,
        ServletException::class,
        InvalidCredentialsException::class,
        UserNotFoundException::class
    )
    override fun commence(
        request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException
    ) {
        response.sendError(400, "Invalid username or password")
    }
}
