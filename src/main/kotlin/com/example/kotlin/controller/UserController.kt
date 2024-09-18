package com.example.kotlin.controller

import com.example.kotlin.dto.User
import com.example.kotlin.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @PostMapping("/")
    fun addUser(@RequestBody user: User): User {
        return userService.save(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@RequestBody user: User, @PathVariable id: Long): User {
        return userService.update(user, id)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User {
        return userService.getById(id)
    }

    @GetMapping("/")
    fun getAllUser(): List<User> {
        return userService.getAllUser()
    }
}