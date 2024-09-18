package com.example.kotlin.entity

import jakarta.persistence.*

@Entity
@Table
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var email: String
) {
}