package com.sorsix.barmanagmentapi.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/storage")
@CrossOrigin
class StorageController {

    @GetMapping("/{id}")
    fun getStorageForLocale(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok().build()
    }
}