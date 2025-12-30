package main.kotlin.casino.core.domain

data class Player(
    val id: Int,
    val name: String,
    val balance: Double,
    val playerType: PlayerType
)