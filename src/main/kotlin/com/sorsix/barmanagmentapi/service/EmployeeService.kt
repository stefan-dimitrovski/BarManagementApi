package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<User> {
        return this.employeeRepository.findByRole()
    }
}