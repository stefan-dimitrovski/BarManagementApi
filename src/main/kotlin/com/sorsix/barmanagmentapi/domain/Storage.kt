package com.sorsix.barmanagmentapi.domain

import javax.persistence.*
import javax.persistence.Table
import javax.validation.constraints.Min

@Entity
@Table(name = "storage")
data class Storage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToOne
    val locale: Locale,
    @ManyToOne
    val drink: Drink,
    @Min(value = 0L, message = "Please insert positive numbers only")
    val quantity: Int,
)
