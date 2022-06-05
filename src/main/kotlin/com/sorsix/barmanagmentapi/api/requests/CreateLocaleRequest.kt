package com.sorsix.barmanagmentapi.api.requests

data class CreateLocaleRequest(
    val address: String,
    val lat: Double,
    val lng: Double,
    val name: String
)