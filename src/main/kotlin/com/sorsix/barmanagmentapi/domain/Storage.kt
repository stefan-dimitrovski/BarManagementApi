package com.sorsix.barmanagmentapi.domain

import javax.persistence.*
import javax.persistence.Table

@Entity
@Table(name = "storage")
data class Storage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val locale: Locale,
    @ManyToOne
    val drink: Drink,
    val quantity: Int,
)
