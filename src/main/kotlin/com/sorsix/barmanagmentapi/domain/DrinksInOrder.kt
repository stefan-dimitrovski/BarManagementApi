package com.sorsix.barmanagmentapi.domain

import javax.persistence.*
import javax.persistence.Table

@Entity
@Table(name = "drinks_in_order")
data class DrinksInOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val drink: Drink,
    @ManyToOne
    val order: Order,
    val quantity: Int,
)
