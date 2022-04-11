//package com.sorsix.barmanagmentapi.service
//
//import com.fasterxml.jackson.annotation.JsonIgnore
//import com.sorsix.barmanagmentapi.domain.User
//import io.jsonwebtoken.lang.*
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import java.util.stream.Collectors
//
//
//data class UserDetailsImpl(
//    private val email: String,
//    private val password: String,
//    private val authorities: Collection<GrantedAuthority>
//) : UserDetails {
//
//
//    override fun getAuthorities(): Collection<GrantedAuthority> {
//        return authorities
//    }
//
//    override fun getPassword(): String {
//        return password
//    }
//
//    override fun getUsername(): String {
//        return email
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return true
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isEnabled(): Boolean {
//        return true
//    }
//
//    override fun equals(o: Any?): Boolean {
//        if (this === o) return true
//        if (o == null || javaClass != o.javaClass) return false
//        val user = o as UserDetailsImpl
//        return Objects.equals(id, user.id)
//    }
//
//
//    companion object {
//        private const val serialVersionUID = 1L
//        fun build(user: User): UserDetailsImpl {
//            val authorities: List<GrantedAuthority> =
//                user.getRoles().stream().map { role -> SimpleGrantedAuthority(role.getName().name()) }
//                    .collect(Collectors.toList())
//            return UserDetailsImpl(
//                user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authorities
//            )
//        }
//    }
//}