package main.kotlin.casino.core.gametypes.slotmachine

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame

class SlotMachineGame: IGame {
    override val name: GameType = GameType.SCRATCHCARD
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 1
    override val supportedBets: List<Float> = listOf(0.1f, 0.2f, 0.5f, 1f, 2f, 5f, 10f)
    override val bets: MutableMap<Player, Bet> = mutableMapOf()

    private lateinit var slotMachine: SlotMachine

    override fun startGame() {
        slotMachine = SlotMachine.standard5x3HorizontalLines()
    }

    override fun endGame(): Map<Player, Float> {
        slotMachine.spin()

        val multiplier = slotMachine.calculateMultiplier()
        val (player, bet) = bets.entries.first()
        val payout = (multiplier * bet.amount).toFloat()

        bets.clear()
        return mapOf(player to payout)
    }

    override fun placeBet(player: Player, bet: Bet){
        player.subtractBalance(bet.amount)
        bets[player] = bet
    }

}