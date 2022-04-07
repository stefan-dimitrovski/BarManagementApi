package com.sorsix.barmanagmentapi.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "drinks_in_order")
private data class DrinksInOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val drink: Drink,
    @ManyToOne
    val order: Order,
    val quantity: Int,
)
