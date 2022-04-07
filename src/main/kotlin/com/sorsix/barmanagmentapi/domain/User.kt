package com.sorsix.barmanagmentapi.domain

import com.sorsix.barmanagmentapi.domain.enumerations.Role
import com.sorsix.barmanagmentapi.passwordEncoder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    val email: String,
    val name: String,
    val phoneNumber: String? = null,
    @Enumerated(EnumType.STRING)
    val role: Role = Role.WAITER,
    @OneToMany
    val locale: List<Locale>? = null
) {
    @Column
    var password = ""
        set(value) {
            field = passwordEncoder().encode(value)
        }

    fun comparePassword(password: String): Boolean =
        passwordEncoder().matches(password, this.password)
}
