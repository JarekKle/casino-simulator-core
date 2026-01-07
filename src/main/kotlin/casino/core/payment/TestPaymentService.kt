package main.kotlin.casino.core.payment

import main.kotlin.casino.core.domain.Player

class TestPaymentService: IPaymentService {
    override fun addFunds(player: Player, amount: Float) {
        player.addBalance(amount)
    }
}