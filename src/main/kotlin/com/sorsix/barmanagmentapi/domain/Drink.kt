package com.sorsix.barmanagmentapi.domain

import com.sorsix.barmanagmentapi.domain.enumerations.DrinkCategory
import javax.persistence.*
import javax.persistence.Table

@Entity
@Table(name = "drinks")
data class Drink(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "brand_name")
    val brandName: String,
    @Enumerated(EnumType.STRING)
    val category: DrinkCategory
)
