package com.sorsix.barmanagmentapi.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sorsix.barmanagmentapi.domain.enumerations.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(
    name = "users"
)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @NotBlank
    @Email
    @Column(unique = true)
    val email: String,
    @NotBlank
    @Size(min = 8, max = 100)
    @JsonIgnore
    private val password: String,
    @NotBlank
    @Size(min = 2, max = 100)
    val name: String,
    val phoneNumber: String? = null,
    @Enumerated(EnumType.STRING)
    val role: Role = Role.WAITER,
    @OneToMany
    val managesLocales: List<Locale>? = null,
    @ManyToOne
    var worksInLocale: Locale? = null
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority(this.role.toString()))

    override fun getUsername(): String = email

    override fun getPassword(): String = password

    override fun isEnabled(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}

