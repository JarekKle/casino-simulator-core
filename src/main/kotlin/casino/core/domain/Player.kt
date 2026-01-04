package main.kotlin.casino.core.domain

data class Player(
    val id: Int,
    val name: String,
    var balance: Float,
    val playerType: PlayerType
){
    fun addBalance(amount: Float) {
        balance += amount
    }

    fun subtractBalance(amount: Float) {
        require(balance >= amount) { "Insufficient balance" }
        balance -= amount
    }
}