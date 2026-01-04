package main.kotlin.casino.core.gametypes.roulette

import main.kotlin.casino.core.game.Bet

sealed class RouletteBet(amount: Float) : Bet(amount) {

    data class Number(val number: Int, val betAmount: Float) : RouletteBet(betAmount)
    data class Color(val color: Color, val betAmount: Float) : RouletteBet(betAmount)
    data class Even(val betAmount: Float) : RouletteBet(betAmount)
    data class Odd(val betAmount: Float) : RouletteBet(betAmount)
}