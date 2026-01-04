package main.kotlin.casino.core.gametypes.roulette

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class RouletteGame: IGame, IRoundBasedGame {
    override val name: GameType = GameType.ROULETTE
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 8
    override val supportedBets: List<Float> = listOf(1f, 5f, 10f, 20f)
    override val bets: MutableMap<Player, Bet> = mutableMapOf()
    override var isGameActive: Boolean = false
    override var isRoundActive: Boolean = false

    private lateinit var roulette: Roulette


    override fun startGame(players: List<Player>) {
        require(!isGameActive) { "Game is currently active" }
        require(players.size >= minPlayers) {"Number of players must be at least $minPlayers"}
        require(players.size <= maxPlayers) {"Number of players must be at most $maxPlayers"}

        require(bets.isNotEmpty()) { "Bet must be placed before starting the game" }
        roulette = Roulette.standardEuropean()
        isGameActive = true
    }

    override fun startRound() {
        require(isGameActive) { "Game is not active" }
        require(!isRoundActive) { "Round is currently active" }
        require(bets.isNotEmpty()) { "Bet must be placed before starting the game" }
        roulette.spin()
        isRoundActive = true
    }

    override fun endRound() {
        require(isGameActive) { "Game is not active" }
        require(isRoundActive) { "Round is not active" }
        resolveBets()
        bets.clear()
        isRoundActive = false
    }

    override fun resolveBets() {
        val result = roulette.lastResult
        for ((player, bet) in bets) {
            when (bet) {
                is RouletteBet.Number -> {
                    if (bet.number == result.number) {
                        val winnings = bet.amount * 35
                        player.addBalance(winnings + bet.amount)
                    }
                }
                is RouletteBet.Color -> {
                    if (bet.color.equals(result.color)) {
                        val winnings = bet.amount * 1
                        player.addBalance(winnings + bet.amount)
                    }
                }
                is RouletteBet.Even -> {
                    if (result.number != 0 && result.number % 2 == 0) {
                        val winnings = bet.amount * 1
                        player.addBalance(winnings + bet.amount)
                    }
                }
                is RouletteBet.Odd -> {
                    if (result.number % 2 == 1) {
                        val winnings = bet.amount * 1
                        player.addBalance(winnings + bet.amount)
                    }
                }
            }
        }
    }

    override fun endGame(){
        require(isGameActive) { "Game is not active" }
        require(!isRoundActive) { "Round is currently active" }
        bets.clear()
        isGameActive = false
    }
    override fun placeBet(player: Player, bet: Bet){
        require(!isRoundActive) { "Cannot place a bet while a round is active" }
        require(supportedBets.contains(bet.amount)) { "Unsupported bet amount, possible bets: $supportedBets" }
        require(!bets.containsKey(player)) { "Bet already placed for player: $player" }

        player.subtractBalance(bet.amount)
        bets[player] = bet
    }

    fun spin(){
        require(isGameActive) { "Game is not active" }
        roulette.spin()
    }
}