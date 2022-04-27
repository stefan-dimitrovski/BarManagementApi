package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.results.EmployeesInLocalesAnalytics
import com.sorsix.barmanagmentapi.service.AnalyticsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin
class AnalyticsController(private val analyticsService: AnalyticsService) {

    @GetMapping("/employees-in-locales")
    fun getEmployeesWorkingInLocales(): ResponseEntity<MutableList<EmployeesInLocalesAnalytics>> =
        ResponseEntity.ok(analyticsService.getEmployeeNumbersByLocale())
}