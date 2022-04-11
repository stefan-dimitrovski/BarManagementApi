//package com.sorsix.barmanagmentapi.config.filters
//
//import com.auth0.jwt.JWT
//import com.auth0.jwt.algorithms.Algorithm
//import com.sorsix.barmanagmentapi.config.JwtConstants
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
//import javax.servlet.FilterChain
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//class JwtAuthorizationFilter(
//    private val userDetailsService: UserDetailsService,
//    private val authManager: AuthenticationManager
//) : BasicAuthenticationFilter(authManager) {
//
//    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
//        val header: String? = request.getHeader(JwtConstants.HEADER_STRING)
//        if (header == null || !header.startsWith(JwtConstants.TOKEN_PREFIX)) {
//            chain.doFilter(request, response)
//        }
//        val authentication = getAuthentication(request)
//        SecurityContextHolder.getContext().authentication = authentication
//        chain.doFilter(request, response)
//    }
//
//    private fun getAuthentication(request: HttpServletRequest): UsernamePasswordAuthenticationToken? {
//        val token: String = request.getHeader(JwtConstants.HEADER_STRING) ?: return null
//        val user: String = JWT.require(Algorithm.HMAC512(JwtConstants.SECRET.toByteArray()))
//            .build().verify(token.replace(JwtConstants.TOKEN_PREFIX, "")).subject ?: return null
//        val userDetails = userDetailsService.loadUserByUsername(user)
//        return UsernamePasswordAuthenticationToken(userDetails.username, userDetails.password, userDetails.authorities)
//    }
//
//}