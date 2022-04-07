package com.sorsix.barmanagmentapi.domain

import com.sorsix.barmanagmentapi.domain.enumerations.Role
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
    val id: Long,
    @Column(unique = true)
    val email: String,
    val password: String,
    val name: String,
    val phoneNumber: String,
    @Enumerated(EnumType.STRING)
    val role: Role,
    @OneToMany
    val locale: List<Locale>
)
