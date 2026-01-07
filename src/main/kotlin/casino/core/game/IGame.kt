package main.kotlin.casino.core.game

import main.kotlin.casino.core.domain.Player

interface IGame {
    val name: GameType
    val minPlayers: Int
    val maxPlayers: Int
    val supportedBets: List<Float>
    val bets: MutableMap<Player, Bet>

    fun startGame(){}
    fun resolveBets(){}
    fun endGame(): Map<Player, Float>
    fun placeBet(player: Player, bet: Bet){}
}