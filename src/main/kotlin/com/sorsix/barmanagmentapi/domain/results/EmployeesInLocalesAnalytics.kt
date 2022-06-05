package com.sorsix.barmanagmentapi.domain.results

import com.sorsix.barmanagmentapi.domain.Locale

class EmployeesInLocalesAnalytics(
    val locale: Locale,
    val employeesByMonth: Map<String, Int>
)