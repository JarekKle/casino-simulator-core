package main.kotlin.casino.core.domain

data class UserAccount(
    val uid: Int,
    val email: String,
    val name: String,
    val surname: String,
    val phoneNumber: String
)