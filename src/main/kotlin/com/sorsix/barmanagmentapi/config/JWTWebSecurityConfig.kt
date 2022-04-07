package com.sorsix.barmanagmentapi.config

import com.sorsix.barmanagmentapi.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class JWTWebSecurityConfig(
    private val passwordEncoder: PasswordEncoderConfig,
    private val userService: UserService
) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/tables/*","/api/tables/close/*","/api/*","/api/account/register","/api/account/home","/api/logout").permitAll()
            .anyRequest()
            .authenticated()
            .and()
//            .addFilter()
//            .addFilter()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

}
