package com.sorsix.barmanagmentapi.domain

import com.sorsix.barmanagmentapi.domain.enumerations.DrinkCategory
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "drinks")
data class Drink(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "brand_name")
    val brandName: String,
    @Enumerated(EnumType.STRING)
    val category: DrinkCategory,

    @NotNull
    val price: Int
)
