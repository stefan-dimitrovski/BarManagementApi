package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.EmployeeLocaleRequest
import com.sorsix.barmanagmentapi.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployees(): List<User> {
        return this.employeeService.getAllEmployees()
    }

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Long): User {
        return this.employeeService.findEmployeeById(id)
    }

    @PutMapping("/add-to-locale")
    fun addEmployeeToLocale(@RequestBody request: EmployeeLocaleRequest): ResponseEntity<Any> {
        val result = this.employeeService.addEmployeeToLocale(request.employeeId, request.localeId)
        return if (result) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.badRequest().build()
        }
    }
}