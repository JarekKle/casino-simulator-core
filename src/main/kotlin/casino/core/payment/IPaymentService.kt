package main.kotlin.casino.core.payment

import main.kotlin.casino.core.domain.Player

interface IPaymentService {
    fun addFunds(player: Player, amount: Float)
}