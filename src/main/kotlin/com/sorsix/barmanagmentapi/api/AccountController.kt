package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.response.AccountResponse
import com.sorsix.barmanagmentapi.api.response.RegisterSuccess
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid


@RestController
@RequestMapping("/api/account")
class AccountController(val userService: UserService) {

    @PostMapping("/register")
    fun createUser(
        @RequestBody @Valid registerDto: RegisterDTO,
        request: HttpServletRequest
    ): ResponseEntity<AccountResponse> {
        val user = userService.save(registerDto)
        return ResponseEntity.ok(RegisterSuccess(user))
//        val userResult = userService.save(registerDto)
//        when (userResult) {
//            is ResultSuccess -> ResponseEntity.ok(RegisterSuccess(userResult.user))
//            is ResultError -> ResponseEntity.badRequest().body(RegisterError("Bad request!"))
//        }
    }

}