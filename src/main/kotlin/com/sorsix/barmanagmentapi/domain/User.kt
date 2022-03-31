package com.sorsix.barmanagmentapi.domain

import javax.persistence.*
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val email: String,
    val password: String,
    val name: String,
    val phoneNumber: String,
    @Enumerated(EnumType.STRING)
    val role: Role,
    @OneToMany
    val locale: List<Locale>
)