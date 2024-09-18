package com.example.kotlin.service

import com.example.kotlin.dto.User
import com.example.kotlin.entity.UserEntity
import com.example.kotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun save(user: User): User {
        val userEntity = userRepository.save(convertToEntity(user))
        return convertToDTO(userEntity)
    }

    override fun update(user: User, id: Long): User {
        user.id = id
        val userEntity = userRepository.save(convertToEntity(user))
        return convertToDTO(userEntity)
    }

    override fun getById(id: Long): User {
        val userEntity: UserEntity = userRepository.findById(id).get()
        return convertToDTO(userEntity)
    }

    override fun getAllUser(): List<User> {
        val userEntityList: List<UserEntity> = userRepository.findAll()
        return userEntityList.map { userEntity -> convertToDTO(userEntity) }
    }

    fun convertToDTO(user: UserEntity): User {
        return User(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

    fun convertToEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }
}