//package com.sorsix.barmanagmentapi.config.filters
//
//import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import com.auth0.jwt.JWT
//import com.auth0.jwt.algorithms.Algorithm
//import com.sorsix.barmanagmentapi.config.JwtConstants
//import com.sorsix.barmanagmentapi.dto.LoginDTO
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//import java.io.IOException
//import java.util.*
//import javax.servlet.FilterChain
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//data class JwtAuthenticationFilter(
//    val authManager: AuthenticationManager,
//    val userDetailsService: UserDetailsService,
//) : UsernamePasswordAuthenticationFilter() {
//
//    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
//        try {
//            val credentials = jacksonObjectMapper().readValue(request.inputStream, LoginDTO::class.java)
//            val user = userDetailsService.loadUserByUsername(credentials.email)
//            return authManager.authenticate(
//                UsernamePasswordAuthenticationToken(
//                    credentials.email,
//                    credentials.password,
//                    user.authorities
//                )
//            )
//        } catch (e: IOException) {
//            throw IOException()
//        }
//    }
//
//    override fun successfulAuthentication(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        chain: FilterChain,
//        authResult: Authentication
//    ) {
//        val userDetails: UserDetails = authResult.principal as UserDetails
//        val token: String = JWT.create().withSubject(userDetails.username)
//            .withExpiresAt(Date(System.currentTimeMillis() + JwtConstants.EXPIRATION_TIME))
//            .sign(Algorithm.HMAC512(JwtConstants.SECRET.toByteArray()))
//        response.addHeader(JwtConstants.HEADER_STRING, JwtConstants.TOKEN_PREFIX + token)
//        response.writer.append(token)
//    }
//
//}
