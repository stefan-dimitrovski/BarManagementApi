package com.sorsix.barmanagmentapi.domain

import javax.persistence.*
import javax.persistence.Table

@Entity
@Table(name = "tables")
data class Table(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "is_open")
    var isOpen: Boolean,
    @ManyToOne
    val waiter: User?
)
