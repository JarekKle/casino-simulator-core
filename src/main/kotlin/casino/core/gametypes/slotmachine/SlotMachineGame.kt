package main.kotlin.casino.core.gametypes.slotmachine

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.gametypes.scratchcard.ScratchCard

class SlotMachineGame: IGame {
    override val name: GameType = GameType.SCRATCHCARD
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 1
    override val supportedBets: List<Float> = listOf(1.0f, 5.0f, 10.0f, 20.0f)
    override val bets: MutableMap<Player, Bet> = mutableMapOf()
    override val isGameActive: Boolean = false

    val slotMachine: SlotMachine = SlotMachine.standard3x3()
}