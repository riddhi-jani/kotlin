package com.example.kotlin.service

import com.example.kotlin.dto.User

interface UserService {
    fun save(user: User): User
    fun update(user: User, id: Long): User
    fun getById(id: Long): User
    fun getAllUser(): List<User>
}