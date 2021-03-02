package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User {
    @Id
    val id: Long = 0L
}

@Repository
interface UserRepository : JpaRepository<User, Long>, CustomUserRepository

interface CustomUserRepository {
    fun saveCustom(user: User): User?
}

class CustomUserRepositoryImpl(
    val userRepository: UserRepository
) : CustomUserRepository {

//    @Autowired
//    lateinit var userRepository: UserRepository

    override fun saveCustom(user: User)= userRepository.save(user)
}