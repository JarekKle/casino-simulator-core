package main.kotlin.casino.core.gametypes.slotmachine

import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.gametypes.scratchcard.ScratchCard

class SlotMachineGame: IGame {
    override val name: GameType = GameType.SCRATCHCARD
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 1
    override val supportedBets: List<Double> = listOf(1.0, 5.0, 10.0, 20.0)
    override val isGameActive: Boolean = false

    val slotMachine: SlotMachine = SlotMachine.standard3x3()
}