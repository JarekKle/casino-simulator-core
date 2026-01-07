package main.kotlin.casino.core.gameroom

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class GameRoom(val game: IGame,maxPlayers: Int) {
    val players: MutableList<Player> = mutableListOf()
    val maxPlayers = minOf(maxPlayers, game.maxPlayers)
    var isActive = false
    fun addPlayer(player: Player) {
        require(players.size <   maxPlayers) { "Players limit reached" }
        players.add(player)
    }

    fun placeBet(player: Player, bet: Bet) {
        require(!isActive) { "Game is currently active" }
        require(players.contains(player)) { "Player $player has already been placed" }
        require(game.supportedBets.contains(bet.amount)) { "Bet ${bet.amount} is not supported: ${game.supportedBets}" }
        player.subtractBalance(bet.amount)
        game.placeBet(player, bet)
    }
    fun startGame() {
        require(players.size <= maxPlayers) { "Number of players must be at most $maxPlayers" }
        require(players.size >= game.minPlayers) { "Number of players must be at least $maxPlayers" }
        isActive = true
        game.startGame()
    }
    fun startRound(){
        if (game !is IRoundBasedGame)
            return
        else{
            val roundGame = game as? IRoundBasedGame
            roundGame?.startRound()
        }
    }
    fun endRound(){
        if (game !is IRoundBasedGame)
            return
        else{
            val roundGame = game as? IRoundBasedGame
            roundGame?.endRound()
        }
    }

    fun endGame(){
        require(isActive) { "Game is not currently active" }
        val payouts = game.endGame()
        payouts.forEach { (player, amount) ->
            player.addBalance(amount)
        }

        isActive = false
    }
}