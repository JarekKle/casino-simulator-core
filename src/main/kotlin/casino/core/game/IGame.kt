package main.kotlin.casino.core.game

import main.kotlin.casino.core.domain.Player

interface IGame {
    val name: GameType
    val minPlayers: Int
    val maxPlayers: Int
    val supportedBets: List<Double>
    val isGameActive: Boolean

    fun startGame(players: List<Player>){}
    fun endGame(){}
    fun placeBet(player: Player, amount: Float){}
}