package com.sorsix.barmanagmentapi.config

import com.sorsix.barmanagmentapi.config.filters.AuthFilter
import com.sorsix.barmanagmentapi.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class WebSecurityConfig(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoderConfig,
    private val authFilter: AuthFilter
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder.passwordEncoder())
    }

    override fun configure(webSecurity: WebSecurity) {
        webSecurity.ignoring().antMatchers("/api/register")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.exceptionHandling().authenticationEntryPoint(UnauthorizedAuthenticationEntryPoint())
        http.cors().and().csrf().disable().authorizeRequests()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/api/tables/**").hasAnyAuthority("WAITER")
            .antMatchers("/api/locales/create").hasAnyAuthority("MANAGER")
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}
