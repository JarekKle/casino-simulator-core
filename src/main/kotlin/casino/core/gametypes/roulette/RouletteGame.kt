package main.kotlin.casino.core.gametypes.roulette

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class RouletteGame : IGame, IRoundBasedGame {

    override val name = GameType.ROULETTE
    override val minPlayers = 1
    override val maxPlayers = 8
    override val supportedBets = listOf(1f, 5f, 10f, 20f)
    override val bets = mutableMapOf<Player, Bet>()

    private lateinit var roulette: Roulette
    private var lastResult: Tile? = null

    override fun startGame() {
        roulette = Roulette.standardEuropean()
    }

    override fun endGame(): Map<Player, Float> {
        val result = lastResult ?: return emptyMap()
        val payouts = mutableMapOf<Player, Float>()

        for ((player, bet) in bets) {
            val winMultiplier = when (bet) {
                is RouletteBet.Number ->
                    if (bet.number == result.number) 35f else 0f

                is RouletteBet.Color ->
                    if (bet.color.equals(result.color)) 1f else 0f

                is RouletteBet.Even ->
                    if (result.number != 0 && result.number % 2 == 0) 1f else 0f

                is RouletteBet.Odd ->
                    if (result.number % 2 == 1) 1f else 0f

                else -> 0f
            }

            if (winMultiplier > 0f) {
                payouts[player] = bet.amount * winMultiplier
            }
        }

        return payouts
    }

    override fun placeBet(player: Player, bet: Bet) {
        bets[player] = bet
    }

    override fun startRound() {
        lastResult = roulette.spin()
    }

    override fun endRound() {
    }
}
