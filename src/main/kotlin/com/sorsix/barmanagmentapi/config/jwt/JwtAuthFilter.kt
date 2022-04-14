package com.sorsix.barmanagmentapi.config.jwt

import com.sorsix.barmanagmentapi.service.AuthService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthFilter(
    val authService: AuthService,
    val jwtUtil: JwtUtil
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val jwt = parseJwt(request)
            if (jwt != null && jwtUtil.validateJwtToken(jwt)) {
                val username: String = jwtUtil.generateUsernameToken(jwt)
                val userDetails = authService.loadUserByUsername(username)
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails!!.authorities //TODO
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (e: Exception) {
            logger.error("Cannot set user authentication: {}", e)
        }
        filterChain.doFilter(request, response)
    }

    private fun parseJwt(request: HttpServletRequest): String? {
        val headerAuth = request.getHeader(JwtConstants.HEADER_STRING)
        return if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(JwtConstants.TOKEN_PREFIX)) {
            headerAuth.substring(7, headerAuth.length)
        } else null
    }
}