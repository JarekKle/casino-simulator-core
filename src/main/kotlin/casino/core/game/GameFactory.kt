package main.kotlin.casino.core.game

import ScratchCardGame
import main.kotlin.casino.core.gametypes.blackjack.BlackJackGame
import main.kotlin.casino.core.gametypes.roulette.RouletteGame
import main.kotlin.casino.core.gametypes.slotmachine.SlotMachineGame

object GameFactory {
    fun create(gameType: GameType): IGame =
        when(gameType){
            GameType.SCRATCHCARD -> ScratchCardGame()
            GameType.SLOT_MACHINE -> SlotMachineGame()
            GameType.ROULETTE -> RouletteGame()
            GameType.BLACKJACK -> BlackJackGame()
        }
    }