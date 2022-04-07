package com.sorsix.barmanagmentapi.config.filters

import com.sorsix.barmanagmentapi.config.PasswordEncoderConfig
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


class AuthenticationFilter(
    val authManager: AuthenticationManager,
    val userDetailsService: UserDetailsService,
    val passwordEncoder: PasswordEncoderConfig
) : UsernamePasswordAuthenticationFilter() {

}
