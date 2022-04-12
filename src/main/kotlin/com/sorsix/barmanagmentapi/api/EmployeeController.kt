package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployees(): List<User> {
        return this.employeeService.getAllEmployees()
    }
}